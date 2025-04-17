//Coupon Servlet
package servlet;

import blockchain.Block;
import blockchain.Blockchain;
import dao.CouponDAO;
import model.Coupon;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class CouponServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Blockchain.initialize();

        String code = req.getParameter("code");
        double discount = Double.parseDouble(req.getParameter("discount"));
        String user = req.getParameter("user");

        String data = code + "-" + discount + "-" + user;
        Blockchain.addBlock(data);
        Block latest = Blockchain.getLatestBlock();

        Coupon coupon = new Coupon();
        coupon.setCode(code);
        coupon.setDiscount(discount);
        coupon.setUser(user);
        coupon.setBlockchainHash(latest.hash);

        new CouponDAO().insertCoupon(coupon);

        req.setAttribute("coupons", new CouponDAO().getAllCoupons());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("coupons", new CouponDAO().getAllCoupons());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}

//web.xml

<web-app>
    <servlet>
        <servlet-name>CouponServlet</servlet-name>
        <servlet-class>servlet.CouponServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>CouponServlet</servlet-name>
        <url-pattern>/CouponServlet</url-pattern>
    </servlet-mapping>
</web-app>