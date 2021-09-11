
-- Find all the clients (first and last name) billing amount and charged date
select clients.first_name, clients.last_name, billing.amount, billing.charged_datetime
from clients
join billing on clients.id = billing.clients_id;





