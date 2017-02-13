<!DOCTYPE html>
<html>
    <head>
        <title>Lost Password Browser</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/main.css">
        <script src="javascript/moment.js"></script>
        <script src="javascript/javascript.js"></script>
    </head>
    <body>
        <section class="row-alt">
            <div class="lead container">

                <h1>Lost Password Browser</h1>

                <form class="col-1-3" method="POST" action="controller" onsubmit="return validateDate()">
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
                            <input id="initDate" name="initDate" type="date" placeholder="YYYY-MM-DD"/>
                            Final Date: 
                            <input id="finalDate" name="finalDate" type="date" placeholder="YYYY-MM-DD"/>
                        </label>
                        
                        <h3 id="DateFormatError" hidden>
                            <font color="red">Please insert date in YYYY-MM-DD format</font>
                        </h3>
                        <hr/>
                        
                        <input class="btn btn-alt" type="submit" value="submit"/>
                    </fieldset>
                </form>
            </div>
        </section>
    </body>
</html>