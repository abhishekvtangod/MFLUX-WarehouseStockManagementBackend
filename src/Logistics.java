

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
 * Servlet implementation class Logistics
 */
@WebServlet("/Logistics")
public class Logistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logistics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		try {


            Connection con = DatabaseConnection.initializeDB();
			
			//JSON to java object using gson
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String qry = "select * from Logistics";
            Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			ArrayList<String> lgArr= new ArrayList<String>();
			while (rs.next()) {
				LogisticsEntity lg = new LogisticsEntity();
				lg.set_logistics_id(rs.getInt(1));
				lg.set_start_addr(rs.getString(2));
				lg.set_end_addr(rs.getString(3));
				lg.set_dispatch_datetime(rs.getTimestamp(4).toString());
				lg.set_receive_datetime(rs.getTimestamp(5).toString());
				lg.set_vehicle(rs.getString(6));
				
				String jsonString = gson.toJson(lg);
			    lgArr.add(jsonString);
			    
			}
			String fin = "{ \"data\" :"+lgArr+"}";

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
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		try {


            Connection con = DatabaseConnection.initializeDB();
			
			//JSON to java object using gson
			BufferedReader reader = request.getReader();
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();

	        LogisticsEntity whObj = gson.fromJson(reader, LogisticsEntity.class); 
			
			System.out.println(whObj);
			PreparedStatement st = con.prepareStatement("insert into Logistics (`logistics_id`, `start_addr`, `end_addr`, `dispatch_datetime`, `receive_datetime`, `vehicle`)  "
					+ "values (?, ?, ?, ?, ?, ?)");

			st.setInt(1, whObj.get_logistics_id());
			st.setString(2, whObj.get_start_addr());
			st.setString(3, whObj.get_end_addr());
			st.setTimestamp(4, Timestamp.valueOf(whObj.get_dispatch_datetime()));
            st.setTimestamp(5, Timestamp.valueOf(whObj.get_receive_datetime()));
            st.setString(6, whObj.get_vehicle());
         
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
