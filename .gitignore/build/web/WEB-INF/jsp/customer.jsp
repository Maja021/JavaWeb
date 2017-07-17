<%@ include file="/WEB-INF/jsp/include.jsp" %> 
<html>
    <head>
        <title>Customer Page</title>
        <%@ include file="/WEB-INF/jsp/design.jsp" %> 
        <link href="${pageContext.request.contextPath}/content/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="/WEB-INF/jsp/navbar.jsp" %> 
        <div style="margin:5px;">
            <h2>Customers page</h2>
            <c:url var="addAction" value="/customer/add" ></c:url>

            <form:form action="${addAction}" commandName="customer">
                <table>
                    <c:if test="${customer.id > 0}">
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
                            <form:label path="firstName">
                                <spring:message text="First Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="firstName" />
                        </td>
                        <td>
                            <form:errors path="firstName" cssClass="error"></form:errors>
                            </td>
                        </tr>

                        <tr>
                            <td>
                            <form:label path="lastName">
                                <spring:message text="Last Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="lastName" />
                        </td>
                        <td>
                            <form:errors path="lastName" cssClass="error"></form:errors>
                            </td>
                        </tr>

                        <tr>
                            <td>
                            <form:label path="email">
                                <spring:message text="Email"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="email" />
                        </td>
                        <td>
                            <form:errors path="email" cssClass="error"></form:errors>
                            </td>
                        </tr>

                        <tr>
                            <td>
                            <form:label path="date">
                                <spring:message text="Date"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="date" />
                        </td>
                        <td>
                            <form:errors path="date" cssClass="error"></form:errors>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                            <c:if test="${customer.id > 0}">
                                <input type="submit"
                                       value="<spring:message text="Edit Customer"/>" />
                            </c:if>
                            <c:if test="${customer.id == 0}">
                                <input type="submit"
                                       value="<spring:message text="Add Customer"/>" />
                            </c:if>
                        </td>
                    </tr>
                </table>	
            </form:form>
            <br>
            <h3>Customers List</h3>
            <c:if test="${!empty listCustomers}">
                <table class="tg">
                    <tr>
                        <th width="80">Customer ID</th>
                        <th width="120">First name</th>
                        <th width="120">Last name</th>
                        <th width="120">Email</th>
                        <th width="120">Date</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listCustomers}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                            <td>${customer.date}</td> 
                            <td><a href="<c:url value='/customer/edit/${customer.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/customer/remove/${customer.id}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>