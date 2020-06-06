package pizza;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class 
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
@WebServlet("/FileUpload")
public class FileUploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the file chosen by the user
				Part filePart = request.getPart("fileToUpload");
				// Getting Application Path
		        String appPath = request.getServletContext().getRealPath("PizzaImage.jsp");
		 
		      
		        
		        // File path where all files will be stored
		        String imagePath = appPath + "images";//!!!!!!!!
		        System.out.println(imagePath);
		        // Creates the file directory if it does not exists
		        File fileDir = new File(imagePath);
		        if (!fileDir.exists()) {
		            fileDir.mkdirs();
		        }
		        System.out.println("****** get submit**********");
		        System.out.println(filePart.getSubmittedFileName());
		        System.out.println("********filename********");
		        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			    System.out.println( fileName);
			    System.out.println("****************");  
		        System.out.println( request.getSession().getServletContext(). getRealPath ("/"));
		        
		      //Get Image Name
		        String imageName = filePart.getSubmittedFileName();
		        System.out.println("*****image name********");  
		        
		        System.out.println(imageName);
		         String path = this.getServletContext().getRealPath("/WebContent/imagesPizza"); 
		         System.out.println(path);
		         
		      System.out.println("*****ecriture dans eclipse********");
		      filePart.write("C:\\Utilisateurs\\Marko\\eclipse-workspace\\PizzaCrud\\WebContent\\imagesPizza"+ File.separator + fileName);
		      
		      System.out.println("*****ecriture dans tomcat********");
		      filePart.write(imagePath + File.separator + fileName); 
		       
		       System.out.println("*****copy fichier  ********");
		       
		      request.getRequestDispatcher("index.jsp").forward(request, response);
				
		      
		}
	
	}
	 

