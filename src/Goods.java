

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
 * Servlet implementation class Goods
 */
@WebServlet("/Goods")
public class Goods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Goods() {
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

            String qry = "select * from Goods";
            Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			ArrayList<String> veArr= new ArrayList<String>();
			while (rs.next()) {
				GoodsEntity ve = new GoodsEntity();

				ve.set_goods_id(rs.getInt(1));
				ve.set_goods_name(rs.getString(2));
			    ve.set_is_sensitive(rs.getInt(3));
			    ve.set_storage(rs.getInt(4));
			    ve.set_weight(rs.getInt(5));
			    ve.set_cost(rs.getInt(6));
			    ve.set_category(rs.getString(7));
			    ve.set_arrival(rs.getInt(8));
			    ve.set_supplier(rs.getInt(9));
			    ve.set_departure(rs.getInt(10));
			    ve.set_consumer(rs.getInt(11));
			    ve.set_wid(rs.getInt(12));
			    ve.set_bin(rs.getInt(13));
			    
			    
				
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

	        GoodsEntity whObj = gson.fromJson(reader, GoodsEntity.class); 
			
			System.out.println(whObj);
			PreparedStatement st = con.prepareStatement("insert into Goods (`goods_id`, `goods_name`, `is_sensitive`, `storage`,`weight`, `cost`,  `category`, `arrival`, `Supplier`, `wid`, `bin`)  "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	
			st.setInt(1, whObj.get_goods_id());
			st.setString(2, whObj.get_goods_name());
			st.setInt(3, whObj.get_is_sensitive());
            st.setInt(4, whObj.get_storage());
            st.setInt(5, whObj.get_weight());
            st.setInt(6, whObj.get_cost());
            st.setString(7, whObj.get_category());
            st.setInt(8, whObj.get_arrival());
            st.setInt(9, whObj.get_supplier());

//            st.setInt(10, whObj.get_departure());
//            st.setInt(11, whObj.get_consumer());
//            
            st.setInt(10, whObj.get_wid());
            st.setInt(11, whObj.get_bin());
            
            
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
