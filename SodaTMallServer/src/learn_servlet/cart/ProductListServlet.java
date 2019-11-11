package learn_servlet.cart;

import learn_servlet.cart.bean.Product;
import learn_servlet.cart.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = new ProductDao().listProduct();
        req.setAttribute("products", productList);
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp);

    }
}
