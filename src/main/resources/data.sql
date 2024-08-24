-- Insert into customer table
INSERT INTO customer (name, email) VALUES ('John Doe', 'john@example.com');

-- Insert into coffee table
INSERT INTO coffee (name, price) VALUES ('Espresso', 2.50);
INSERT INTO coffee (name, price) VALUES ('Latte', 3.00);
INSERT INTO coffee (name, price) VALUES ('Cappuccino', 3.50);

-- Insert into orders table (ensure customer_id and coffee_id exist)
INSERT INTO orders (customer_id, coffee_id, order_date) VALUES (1, 1, '2024-08-22');
 