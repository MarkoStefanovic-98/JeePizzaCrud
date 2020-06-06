package pizza;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

public class PizzaDao {
	static List<Pizza> listPizza = new ArrayList<Pizza>();

	
    static public List<Pizza> listAllPizzas() throws SQLException, ClassNotFoundException {
    
     String sql = "SELECT * FROM t_pizza";
      
    Connection conn = Connexion.initializeDatabase() ;
      
     Statement statement = conn.createStatement();
     ResultSet resultSet = statement.executeQuery(sql);
     listPizza.clear();
     while (resultSet.next()) {
         int id = resultSet.getInt("id");
         String DesignPizz = resultSet.getString("DesignPizz");	         
         Double price = resultSet.getDouble("TarifPizz");
         String Description = resultSet.getString("Description");
         
          
         Pizza itemPizza = new Pizza(id, DesignPizz, price, Description);
         listPizza.add(itemPizza);
         
     }
     
     resultSet.close();
     statement.close();
           
     return listPizza;
     
}
    static public Pizza getPizzaById(int pizzaid) throws SQLException, ClassNotFoundException {
 	   
 	   Connection conn = Connexion.initializeDatabase() ;
	       		        
        String query = "select * from t_pizza where id = " + pizzaid;
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery(query);
        res.next();
        
        Pizza pizza = new Pizza(res.getInt("id"),res.getString("DesignPizz"),res.getDouble("TarifPizz"), res.getString("Description"));
        stmt.close();
        res.close();
        return pizza;
    }
    
    static public boolean deletePizza(int id) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		try (Connection conn = Connexion.initializeDatabase();
				PreparedStatement statement = conn.prepareStatement("delete from t_pizza where id ="+id);){
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
    static public boolean ajouterPizza(String DesignPizz, Double TarifPizz, String Description) throws SQLException, ClassNotFoundException {
    	boolean rowUpdated;
		String sql = "INSERT INTO t_pizza (DesignPizz, TarifPizz, Description) VALUES (?, ?, ?)";
		try (Connection connection = Connexion.initializeDatabase();
				PreparedStatement statement = connection.prepareStatement(sql);){
				statement.setString(1, DesignPizz);
				statement.setDouble(2, TarifPizz);
				statement.setString(3, Description);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	  	   
	 }
    
	static public boolean updatePizza(int id, String DesignPizz, double TarifPizz, String Description) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		String query = "UPDATE t_pizza SET DesignPizz = ?, TarifPizz = ?, Description = ? where id = ?;";
		try (Connection connection = Connexion.initializeDatabase();
				PreparedStatement statement = connection.prepareStatement(query);){
				statement.setString(1, DesignPizz);
				statement.setDouble(2, TarifPizz);
				statement.setString(3, Description);
				statement.setInt(4, id);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	 

}
        
	