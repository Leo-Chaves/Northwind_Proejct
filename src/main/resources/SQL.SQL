USE Northwind;
Go

CREATE PROCEDURE GetAllCustomers
AS
BEGIN
    SELECT * FROM Customers
END

Go

CREATE PROCEDURE GetAllOrders
AS
BEGIN
    SELECT * FROM Orders
END

Go

CREATE PROCEDURE GetVendasPorMes
    @EmployeeID int,
    @Year int,
    @Month int
AS
BEGIN
    SET NOCOUNT ON;

    SELECT COUNT(*) AS SalesCount, c.ContactName
    FROM Orders o
    JOIN Customers c ON o.CustomerID = c.CustomerID
    WHERE o.EmployeeID = @EmployeeID
    AND YEAR(o.OrderDate) = @Year
    AND MONTH(o.OrderDate) = @Month
    GROUP BY c.ContactName;
END



