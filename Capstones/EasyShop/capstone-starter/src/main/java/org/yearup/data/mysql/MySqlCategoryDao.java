package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories()
    {
        // get all categories
        String query = "{CALL GetAllCategories}";

        List<Category> allCategories = new ArrayList<>();

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            ResultSet resultSet = callableStatement.executeQuery();

            while(resultSet.next()){

                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("name");
                String categoryDescription = resultSet.getString("description");

                Category category = new Category(categoryId, categoryName, categoryDescription);

                allCategories.add(category);
            }

        }
        catch (SQLException ex){
            System.out.println("Couldn't return all the categories for you.");
        }

        return allCategories;
    }

    @Override
    public Optional<Category> getById(int categoryId)
    {
        // get category by id
        String query = "{CALL GetCategoryByID(?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setInt(1, categoryId);

            ResultSet row = callableStatement.executeQuery();

            if(row.next()){
                return Optional.of(mapRow(row));
            }
        }
        catch (SQLException ex){
            System.out.println("Couldn't return that category by its ID.");
        }

        return Optional.empty();
    }

    @Override
    public Category create(Category category)
    {
        // create a new category
        String query = "{CALL CreateCategory(?, ?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setString(1, category.getName());
            callableStatement.setString(2, category.getDescription());

            callableStatement.executeUpdate();

            System.out.println("Category successfully created!");

            return category;

        }
        catch (SQLException ex){
            System.out.println("Couldn't create that category.");
        }

        return null;
    }

    @Override
    public void update(int categoryId, Category category)
    {
        // update category
        String query = "{CALL UpdateCategory(?, ?, ?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setInt(1, categoryId);
            callableStatement.setString(2, category.getName());
            callableStatement.setString(3, category.getDescription());

            callableStatement.executeUpdate();

            System.out.println("Category successfully updated!");

        }
        catch (SQLException ex){
            System.out.println("Couldn't update this category.");
        }
    }

    @Override
    public void delete(int categoryId)
    {
        // delete category
        String query = "{CALL DeleteCategory(?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setInt(1, categoryId);

            callableStatement.executeUpdate();

            System.out.println("Successfully deleted category!");

        }
        catch (SQLException ex){
            System.out.println("Couldn't delete this category.");
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
