package utils.repository.specifications;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Update user specification.
 */
public class UpdateUserSpecification extends SqlSpecification<User> {

    /**
     * Instantiates a new Update user specification.
     *
     * @param entity the entity
     */
    public UpdateUserSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("UPDATE user_account SET username = ?, password = ?, type = ? WHERE id = ?");
        statement.setString(1, this.entity.getUsername().trim());
        statement.setString(2, this.entity.getPassword().trim());
        statement.setString(3, this.entity.getType().toString().trim());
        statement.setInt(4, this.entity.getId());
        return statement;
    }
}
