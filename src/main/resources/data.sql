INSERT INTO products (id, name) VALUES (35455, 'camisa');

INSERT INTO brands(id, name) VALUES (1, 'ZARA');


INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)VALUES (1, 1,PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), 1, 35455, 0, 35.50, 'EUR');
INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES (2, 1, PARSEDATETIME('2020-06-14-15.00.00', 'yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-06-14-18.30.00', 'yyyy-MM-dd-HH.mm.ss'), 2, 35455, 1, 25.45, 'EUR');
INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES (3, 1, PARSEDATETIME('2020-06-15-00.00.00', 'yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-06-15-11.00.00', 'yyyy-MM-dd-HH.mm.ss'), 3, 35455, 1, 30.50, 'EUR');
INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES (4, 1, PARSEDATETIME('2020-06-15-16.00.00', 'yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'), 4, 35455, 1, 38.95, 'EUR');

