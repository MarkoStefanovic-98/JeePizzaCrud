package pizza;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ControllerPizza
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
@WebServlet("/ControllerPizza")
public class ControllerPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() {
		new PizzaDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("modifpizza")) {
			try {
				modifOnePizza(request, response);
			} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		if (action.equalsIgnoreCase("modifpizzavalid"))
			try {
				modifOnePizzaValid(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if (action.equalsIgnoreCase("editpizza"))
			{
				try {
					editOnePizza(request, response);
				} catch (ClassNotFoundException | IOException | SQLException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
		
		if (action.equalsIgnoreCase("addpizza"))
			try {
				addPizza(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if (action.equalsIgnoreCase("addPizzaValid"))
			try {
				addPizzaValid(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		if (action.equalsIgnoreCase("deletepizza"))
			{
				try {
					deletePizza(request, response);
				} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}

		if (action.equalsIgnoreCase("listpizza"))
			{
				try {
					affichelistepizza(request, response);
				} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
	}
	
	private void addPizza(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		request.getRequestDispatcher("PizzaAddView.jsp").forward(request, response);

			}
	
	private void addPizzaValid(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		String DesignPizz = request.getParameter("DesignPizz");
		String id = request.getParameter("idpizza");
		String priceString = request.getParameter("TarifPizz");
		String Description = request.getParameter("Description");
		Double TarifPizz = Double.parseDouble(priceString);
		PizzaDao.ajouterPizza(DesignPizz, TarifPizz, Description);
		Part filePart = request.getPart("fileToUpload");
		String appPath = request.getServletContext().getRealPath("");
		String imagePath = appPath + "imagesPizza";
		String fileName = id+".jpg";
		  File fileDir = new File(imagePath);
	        if (!fileDir.exists()) {
	            fileDir.mkdirs();
	        } 
        System.out.println(imagePath);
        filePart.write(imagePath + File.separator + fileName); 
        File source = new File( imagePath + File.separator + fileName);
	    File dest2 =new File("C:\\Utilisateurs\\Marko\\eclipse-workspace\\PizzaCrud\\WebContent\\imagesPizza"+ File.separator + fileName);
	    Files.copy(source.toPath(), dest2.toPath());
        request.getRequestDispatcher("index.jsp").forward(request, response);
	       
		}
	
	private void modifOnePizza(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
			
			int idpizza = Integer.parseInt(request.getParameter("idpizza"));
			Pizza modifpizza = PizzaDao.getPizzaById(idpizza);
			request.setAttribute("modifpizza", modifpizza);
			request.getRequestDispatcher("PizzaModifView.jsp").forward(request, response);
			

			}
	private void modifOnePizzaValid(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
			String id = request.getParameter("idpizza");
			String DesignPizz = request.getParameter("DesignPizz");
			String priceString = request.getParameter("TarifPizz");
			String Description = request.getParameter("Description");
			Double TarifPizz = Double.parseDouble(priceString);
			int id1 = Integer.parseInt(id);
			PizzaDao.updatePizza(id1, DesignPizz, TarifPizz, Description);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			}
	
		
		private void deletePizza(HttpServletRequest request, HttpServletResponse response) 
				throws ClassNotFoundException, SQLException, ServletException, IOException {
				
			int id = Integer.parseInt(request.getParameter("idpizza"));
			PizzaDao.deletePizza(id);
			request.getRequestDispatcher("index.jsp").forward(request, response);

				}
		
		private void affichelistepizza(HttpServletRequest request, HttpServletResponse response)
				throws ClassNotFoundException, SQLException, ServletException, IOException {

			List<Pizza> listpizza = PizzaDao.listAllPizzas();
			request.setAttribute("listpizza", listpizza);
			request.getRequestDispatcher("PizzaListView.jsp").forward(request, response);

		}

		private void editOnePizza(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ClassNotFoundException, SQLException, ServletException {

			int idpizza = Integer.parseInt(request.getParameter("idpizza"));
			Pizza maPizza = PizzaDao.getPizzaById(idpizza);
			request.setAttribute("mapizza", maPizza);
			request.getRequestDispatcher("LaPizzaView.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
}


