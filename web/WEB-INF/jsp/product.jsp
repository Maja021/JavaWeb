<%@ include file="/WEB-INF/jsp/include.jsp" %> 
<html>
    <head>
        <title>Product Page</title>
        <%@ include file="/WEB-INF/jsp/design.jsp" %> 
        <link href="${pageContext.request.contextPath}/content/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %> 
        <div style="margin:5px;">
            <h2>Product page</h2>
            <c:url var="addAction" value="/product/add" ></c:url>

            <form:form action="${addAction}" commandName="product">
                <table>
                    <c:if test="${product.id > 0}">
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="id" readonly="true" size="8"  disabled="true" />
                                <form:hidden path="id" />
                            </td> 
                        </tr>
                    </c:if>
                        
                        <tr>
                            <td>
                            <form:label path="name">
                                <spring:message text="Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="name" />
                        </td>
                        <td>
                            <form:errors path="name" cssClass="error"></form:errors>
                            </td>
                        </tr>
                        
                        <tr>
                        <td>
                            <form:label path="price">
                                <spring:message text="Price"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="price" />
                        </td>
                        <td>
                            <form:errors path="price" cssClass="error"></form:errors>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                            <c:if test="${product.id > 0}">
                                <input type="submit"
                                       value="<spring:message text="Edit Product"/>" />
                            </c:if>
                            <c:if test="${product.id == 0}">
                                <input type="submit"
                                       value="<spring:message text="Add Product"/>" />
                            </c:if>
                        </td>
                    </tr>
                </table>	
            </form:form>
            <br>
            <h3>Products List</h3>
            <c:if test="${!empty listProducts}">
                <table class="tg">
                    <tr>
                        <th width="80">Product ID</th>
                        <th width="120">Name</th>
                        <th width="120">Price</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listProducts}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td><a href="<c:url value='/product/edit/${product.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/product/remove/${product.id}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>