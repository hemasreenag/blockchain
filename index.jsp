//JSP Frontend
<%@ page import="java.util.*, model.Coupon" %>
<%
    ArrayList<Coupon> coupons = (ArrayList<Coupon>) request.getAttribute("coupons");
%>

<html>
<head><title>Secure E-Coupon System</title></head>
<body>
    <h2>Create Coupon</h2>
    <form method="post" action="CouponServlet">
        Code: <input type="text" name="code" required /><br/>
        Discount: <input type="number" name="discount" required /><br/>
        User: <input type="text" name="user" required /><br/>
        <input type="submit" value="Generate Coupon" />
    </form>

    <h2>Coupon List</h2>
    <table border="1">
        <tr><th>Code</th><th>Discount</th><th>User</th><th>Blockchain Hash</th></tr>
        <%
            if (coupons != null) {
                for (Coupon c : coupons) {
        %>
            <tr>
                <td><%= c.getCode() %></td>
                <td><%= c.getDiscount() %></td>
                <td><%= c.getUser() %></td>
                <td><%= c.getBlockchainHash() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>