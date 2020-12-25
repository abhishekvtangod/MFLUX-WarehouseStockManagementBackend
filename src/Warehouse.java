

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

import com.google.gson.*;

/**
 * Servlet implementation class Warehouse
 */
@WebServlet("/Warehouse")
public class Warehouse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Warehouse() {
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

            String qry = "select * from Warehouse";
            Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			ArrayList<String> whArr= new ArrayList<String>();
			while (rs.next()) {
				WarehouseEntity wh = new WarehouseEntity();
			    wh.set_Wid(rs.getInt(1));
			    wh.set_is_functional(rs.getInt(2));
//			    wh.set_capacity(rs.getInt(3));
			    wh.set_company(rs.getString(3));
			    wh.set_address(rs.getString(4));
//			    wh.set_latitude(rs.getString(6));
//			    wh.set_longitude(rs.getString(7));
			    wh.set_supervisor_id(rs.getInt(5));
			    String jsonString = gson.toJson(wh);
			    whArr.add(jsonString);
			    
			}
			String fin = "{ \"data\" : "+whArr+"}";

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

			WarehouseEntity whObj = gson.fromJson(reader, WarehouseEntity.class); 
			
			System.out.println(whObj);
			PreparedStatement st = con.prepareStatement("insert into Warehouse (`Wid`, `is_functional`, `company`, `address`)  "
					+ "values (?, ?, ?, ?)");
			
			st.setInt(1, whObj.get_Wid());
			st.setInt(2, whObj.get_is_functional());
//			st.setInt(3, whObj.get_capacity());
			st.setString(3, whObj.get_company());
            st.setString(4, whObj.get_address());
//            st.setString(6, whObj.get_latitude());
//            st.setString(7, whObj.get_longitude());
//            st.setInt(8, whObj.get_supervisor_id());
           
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
