

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Consumer
 */
@WebServlet("/Consumer")
public class Consumer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consumer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		try {


            Connection con = DatabaseConnection.initializeDB();
			
			//JSON to java object using gson
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String qry = "select * from Consumer";
            Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			ArrayList<String> veArr= new ArrayList<String>();
			while (rs.next()) {
				ConsumerEntity ve = new ConsumerEntity();

				ve.set_consumer_id(rs.getInt(1));
				ve.set_consumer_name(rs.getString(2));
				ve.set_phone(rs.getString(3));
				ve.set_email(rs.getString(4));
				
				
				
			    String jsonString = gson.toJson(ve);
			    veArr.add(jsonString);
			    
			}
			String fin = "{ \"data\" :"+veArr+"}";

			out.print(fin);
			con.close();
            
			System.out.println("{ \"Result\": \"DB data fetched successfully\" }");

            out.flush();
            
            
		}catch(Exception e) {

			out.print("{ \"Result\": \"Getting info from DB failed\" }");
			e.printStackTrace();
		}



	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();

		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		try {


            Connection con = DatabaseConnection.initializeDB();
			
			//JSON to java object using gson
			BufferedReader reader = request.getReader();
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();

	        ConsumerEntity whObj = gson.fromJson(reader, ConsumerEntity.class); 
			
			System.out.println(whObj);
			PreparedStatement st = con.prepareStatement("insert into Consumer (`consumer_id`, `consumer_name`, `phone`, `email`)  "
					+ "values (?, ?, ?, ?)");

			st.setInt(1, whObj.get_consumer_id());
			st.setString(2, whObj.get_consumer_name());
			st.setString(3, whObj.get_phone());
            st.setString(4, whObj.get_email());
         
            st.executeUpdate();
            con.close();
            
			out.print("{ \"Result\": \"inserted successfully\" }");

            out.flush();
            
            
		}catch(Exception e) {

			out.print("{ \"Result\": \"Insertion failed\" }");
			e.printStackTrace();
		}

	}

}
