<%@ include file="/WEB-INF/jsp/include.jsp" %> 
<html>
    <head>
        <title>Buy Page</title>
        <%@ include file="/WEB-INF/jsp/design.jsp" %> 
        <link href="${pageContext.request.contextPath}/content/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %>
        <div style="margin:5px;">
            <h2>Buy page</h2>
            <c:if test="${!empty listCustomers}">
                <c:url var="setCustomer" value="/buy/set" ></c:url>
                <table>
                  <form:form action="${setCustomer}" commandName="selectedCustomer">
                    <tr>                
                        <td>Customers:</td>
                        <td><form:select path="id">
                            <c:forEach var="customer" items="${listCustomers}">
                                <form:option value="${customer.id}"><c:out value="${customer}"/></form:option>
                            </c:forEach>
                            </form:select>
                        </td>
                        <td>
                            <input type="submit" value="<spring:message text="Set Customer"/>" />
                        </td>
                    </tr>
                   </form:form>
                </table>
            </c:if>
            <br>

            <c:if test="${!empty listProducts}">
                <h3>Products table</h3>
                <c:url var="buyProduct" value="/buy/pay" ></c:url>
                    ${customerName}
                    <table class="tg tg-hide">
                        <tr>
                            <th width="80">Product ID</th>
                            <th width="120">Name</th>
                            <th width="120">Price</th>
                        </tr>
                    <c:forEach items="${listProducts}" var="product">
                        <tr>
                         <form:form action="${buyProduct}" commandName="product">
                            <td>  <form:input path="id" value="${product.id}" readonly="true" /> </td>
                            <td> <form:input path="name" value="${product.name}" readonly="true" /> </td>
                            <td> <form:input path="price" value="${product.price}" readonly="true" /> </td>
                            <td>
                            <input type="submit" value="<spring:message text="Buy Product"/>" />          
                            </td>
                        </form:form>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>