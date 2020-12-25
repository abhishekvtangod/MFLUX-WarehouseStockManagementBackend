

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
 * Servlet implementation class Vehicle
 */
@WebServlet("/Vehicle")
public class Vehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehicle() {
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

            String qry = "select * from Vehicle";
            Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			ArrayList<String> veArr= new ArrayList<String>();
			while (rs.next()) {
				VehicleEntity ve = new VehicleEntity();
				ve.set_reg_num(rs.getString(1));
				ve.set_model(rs.getString(2));
				ve.set_type(rs.getString(3));
				ve.set_last_maintainence(rs.getDate(4).toString());
				ve.set_in_wh(rs.getInt(5));
				
			    String jsonString = gson.toJson(ve);
			    veArr.add(jsonString);
			    
			}
			String fin = "{ \"data\" : "+veArr+"}";

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

	        VehicleEntity whObj = gson.fromJson(reader, VehicleEntity.class); 
			
			System.out.println(whObj);
			PreparedStatement st = con.prepareStatement("insert into Vehicle (`reg_num`, `model`, `type`, `last_maintainence`, `in_wh`)  "
					+ "values (?, ?, ?, ?, ?)");

			st.setString(1, whObj.get_reg_num());
			st.setString(2, whObj.get_model());
			st.setString(3, whObj.get_type());
			st.setDate(4, Date.valueOf(whObj.get_last_maintainence()));
            st.setInt(5, whObj.get_in_wh());
         
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
