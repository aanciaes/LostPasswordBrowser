<%-- 
    Document   : QueryByExample
    Created on : Jan 27, 2017, 12:59:36 AM
    Author     : miguel
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="personal.miguel.lostpasswordbrowser.model.Entry"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.apache.logging.log4j.Logger"%>
<%@page import="org.apache.logging.log4j.LogManager"%>
<%@page import="personal.miguel.lostpasswordbrowser.HibernateSessionManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lost Password Browser</title>
        <link rel="stylesheet" href="stylesheets/main.css">
        <!--                <style>
                           table {
                                margin-left: auto;
                                margin-right: auto;
                                border-collapse: collapse;
                                width: 95%;
                            }
                
                            th, td {
                                text-align: left;
                                padding: 8px;
                            }
                
                            tr:nth-child(even){background-color: #f2f2f2}
                            tr:hover {background-color: #BDBDBD}
                
                            th {
                                background-color: #848484;
                                color: white;
                            }
                        </style>-->
    </head>
    <body>
        <section class="row-alt">
            <div class="lead container">
                <h1>Query Results</h1>
                <table>
                    <tr class="row row-alt">
                        <th>User ID</th>
                        <th>Ticket</th>
                        <th>Timestamp</th>
                        <th>Status</th>
                    </tr>

                    <%
                        List<Entry> lst = (List) request.getAttribute("queryResults");

                        if (lst.size() > 0) {

                            for (Entry entry : lst) {%>
                    <tr class = "row">

                        <td><%=entry.getUserId()%></td>
                        <td><%=entry.getTicket()%></td>
                        <td><%=entry.getTimestamp().toString()%></td>
                        <td><%=entry.getStatus()%></td>
                    </tr>

                    <%}
                    } else {%>
                    <tr class="row">
                        <td>No results with that criteria</td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <%
                        }
                    %>
                </table><br/><hr/><br/>
                <form method="POST" action="index.jsp">
                    <input class="btn btn-alt" type="submit" value="Go Back"/>
                </form>
            </div>
        </section>
    </body>
</html>
