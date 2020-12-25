

import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class Employee
 */
@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
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

            String qry = "select * from Employee";
            Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			ArrayList<String> eeArr= new ArrayList<String>();
			while (rs.next()) {
				EmployeeEntity ee = new EmployeeEntity();
				ee.set_empid(rs.getInt(1));
				ee.set_emp_name(rs.getString(2));
				ee.set_emp_shift(rs.getString(3));
				ee.set_emp_sal(rs.getInt(4));
				ee.set_wid(rs.getInt(5));
				
			    String jsonString = gson.toJson(ee);
			    eeArr.add(jsonString);
			    
			}
			String fin = "{ \"data\" :"+eeArr+" }";

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

			EmployeeEntity whObj = gson.fromJson(reader, EmployeeEntity.class); 
			
			System.out.println(whObj);
			PreparedStatement st = con.prepareStatement("insert into Employee (`empid`, `emp_name`, `emp_shift`, `emp_sal`, `wid`)  "
					+ "values (?, ?, ?, ?, ?)");
			
			st.setInt(1, whObj.get_empid());
			st.setString(2, whObj.get_emp_name());
			st.setString(3, whObj.get_emp_shift());
			st.setInt(4, whObj.get_emp_sal());
            st.setInt(5, whObj.get_wid());
         
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
