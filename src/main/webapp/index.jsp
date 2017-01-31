<!DOCTYPE html>
<html>
    <head>
        <title>Lost Password Browser</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/main.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400"> 
    </head>
    <body>
        <section class="row-alt">
            <div class="lead container">
                
                <h1>Lost Password Browser</h1>
                
                <form class="col-1-3" method="POST" action="controller">
                    <fieldset class="query-group">
                        <input type="hidden" name="todo" value ="queryByExample"/>

                        <label>
                            User ID:
                            <input name="userId" type="text"/>
                        </label>

                        <label>
                            Ticket:
                            <input name="ticket" type="text"/>
                        </label>

                        <label>
                            Email:
                            <input name="email" type="text"/>
                        </label>

                        <label>
                            Initial Date:
                            <input name="initDate" type="date"/>  Final Date: <input name="finalDate" type="date"/>
                        </label>
                        <hr/>
                        <input class="btn btn-alt" type="submit" value="submit"/>
                    </fieldset>
                </form>
            </div>
        </section>
    </body>
</html>