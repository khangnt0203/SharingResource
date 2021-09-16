/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import khangnt.dto.UserDTO;
import khangnt.utils.MyConnection;

/**
 *
 * @author haudq
 */
public class UserDAO implements Serializable {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private void closeConnection() throws Exception {
        if (resultSet != null) {
            connection.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public boolean checkUserId(String userId) throws Exception {
        boolean result = false;
        try {
            connection = MyConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT Id FROM tblUser where UserID = ?");
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean activeAccount(String userID) throws Exception {
        boolean result;
        try {
            connection = MyConnection.getConnection();
            preparedStatement = connection.prepareCall("Update tblUser set Status = ? where UserID = ?");
            preparedStatement.setString(1, "active");
            preparedStatement.setString(2, userID);
            result = preparedStatement.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean createAccount(UserDTO dto) throws Exception {
        boolean result;
        try {
            connection = MyConnection.getConnection();
            preparedStatement = connection.prepareCall("INSERT INTO tblUser (UserID, "
                    + " Password, Name, Phone, Address, RoleID, Status) VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, dto.getUserId());
            preparedStatement.setString(2, dto.getPassword());
            preparedStatement.setString(3, dto.getName());
            preparedStatement.setString(4, dto.getPhone());
            preparedStatement.setString(5, dto.getAddress());
            preparedStatement.setString(6, dto.getRole());
            preparedStatement.setString(7, dto.getStatus());

            result = preparedStatement.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }

    public UserDTO loginByGoogle(String email) throws Exception {
        try {
            connection = MyConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT Id, UserID, RoleName as Role, Name, Status "
		    + "FROM tblUser u join tblRole r ON u.RoleID = r.roleID WHERE UserID = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
		UserDTO result = new UserDTO();
                result.setId(resultSet.getInt("Id"));
                result.setUserId(resultSet.getString("UserID"));
                result.setName(resultSet.getString("Name").trim());
                result.setRole(resultSet.getString("Role").trim());
                result.setStatus(resultSet.getString("Status").trim());
		
		return result;
            }
        } finally {
            closeConnection();
        }
        return null;
    }
    
    public void insertGoogleAccount(String email, String fullname)
	    throws SQLException, NamingException {
	Connection cn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
	    cn = MyConnection.getConnection();
	    if (cn != null) {
		String sql = "INSERT INTO tblUser (UserID, Password, Name, RoleID, Status, Phone, Address) "
			+ "VALUES(?,?,?,?,?,?,?)";
		pst = cn.prepareStatement(sql);
		pst.setString(1, email);
		pst.setString(2, email + fullname + "!@#");
		pst.setString(3, fullname);
		pst.setString(4, "2"); //default employee ID
		pst.setString(5, "Active"); //default google account status
		pst.setString(6, "0123456789");
		pst.setString(7, "Nope");
		pst.executeUpdate();
	    }
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (pst != null) {
		pst.close();
	    }
	    if (cn != null) {
		cn.close();
	    }
	}
    }

    public UserDTO loginByUserIdAndPassword(String userId, String password) throws Exception {
        UserDTO result = new UserDTO();
        try {
            connection = MyConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT Id, RoleName as Role, Name, Status "
		    + "FROM tblUser u join tblRole r ON u.RoleID = r.roleID "
		    + "WHERE UserID = ? and Password = ?");
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result.setId(resultSet.getInt("Id"));
                result.setName(resultSet.getString("Name").trim());
                result.setRole(resultSet.getString("Role").trim());
                result.setStatus(resultSet.getString("Status").trim());
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public int getID(String userID) throws Exception{
        int id=0;
        try{
            connection = MyConnection.getConnection();
            preparedStatement = connection.prepareStatement("Select Id "
                    + "from tblUser "
                    + "where UserID = ?");
            preparedStatement.setString(1, userID);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                id=resultSet.getInt("Id");
            }
        }finally{
            closeConnection();
        }
        return id;
    }
}
