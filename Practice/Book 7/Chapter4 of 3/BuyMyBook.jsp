<html>
<jsp:useBean id="cart" 	
 class="com.lowewriter.books.BookCart" scope="session"/>
<jsp:setProperty name="cart" property="*" />	
  <head>
    <title>Buy My Books!</title>
  </head>
  <body>
    <h1>Which of my books do you want to buy?</h1>
    <form action="BuyMyBook.jsp?book=elecaio" 	
          method="post">
      <input type="submit" value="Buy" >&nbsp;&nbsp;
      Electronics All-in-One For Dummies<br><br>
    </form>
    <form action="BuyMyBook.jsp?book=netaio" 	
          method="post">
      <input type="submit" value="Buy" >&nbsp;&nbsp;
      Networking All-in-One Desk Reference 
        For Dummies
      <br><br>
    </form>
    <form action="BuyMyBook.jsp?book=wordaio" 	
          method="post">
      <input type="submit" value="Buy" >&nbsp;&nbsp;
      Java All-in-One Desk Reference For Dummies
      <br><br>
    </form>
    <br><h2>Your cart contains:</h2>
    <jsp:getProperty name="cart" property="list" />	
  </body>
</html>
