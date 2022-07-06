INSERT INTO TENANT (name) VALUES ('tenant1');
INSERT INTO TENANT (name) VALUES ('tenant2');
INSERT INTO TENANT (name) VALUES ('tenant3');
INSERT INTO TENANT (name) VALUES ('tenant4');
INSERT INTO TENANT (name) VALUES ('tenant5');
INSERT INTO TENANT (name) VALUES ('tenant6');
INSERT INTO TENANT (name) VALUES ('tenant7');
INSERT INTO TENANT (name) VALUES ('tenant8');
INSERT INTO TENANT (name) VALUES ('tenant9');

INSERT INTO RENTER (name) VALUES ('renter1');
INSERT INTO RENTER (name) VALUES ('renter2');
INSERT INTO RENTER (name) VALUES ('renter3');
INSERT INTO RENTER (name) VALUES ('renter4');
INSERT INTO RENTER (name) VALUES ('renter5');
INSERT INTO RENTER (name) VALUES ('renter6');
INSERT INTO RENTER (name) VALUES ('renter7');
INSERT INTO RENTER (name) VALUES ('renter8');
INSERT INTO RENTER (name) VALUES ('renter9');

INSERT INTO ITEM_LEASED (name, unit_cost, area) VALUES ('property1', 13.2, 500.5);
INSERT INTO ITEM_LEASED (name, unit_cost, area) VALUES ('property2', 15.8, 1500);
INSERT INTO ITEM_LEASED (name, unit_cost, area, description) VALUES ('property3', 5, 123.25, 'description3');
INSERT INTO ITEM_LEASED (name, unit_cost, area, description) VALUES ('property4', 25.58, 222.39, 'description4');
INSERT INTO ITEM_LEASED (name, unit_cost, area, description) VALUES ('property5', 56.4, 350.56, 'description5');
INSERT INTO ITEM_LEASED (name, unit_cost, area) VALUES ('property6', 23.1, 12.4);
INSERT INTO ITEM_LEASED (name, unit_cost, area) VALUES ('property7', 25.1, 65.4);
INSERT INTO ITEM_LEASED (name, unit_cost, area) VALUES ('property8', 3.1, 327.12);

INSERT INTO RESERVATION (renter_id, tenant_id, item_leased_id, cost, lease_start, lease_end) VALUES (1, 1, 1, 1600,    '2002-03-05', '2003-03-06');
INSERT INTO RESERVATION (renter_id, tenant_id, item_leased_id, cost, lease_start, lease_end) VALUES (1, 1, 1, 2250.30, '2003-03-06', '2003-08-25');
INSERT INTO RESERVATION (renter_id, tenant_id, item_leased_id, cost, lease_start, lease_end) VALUES (3, 2, 3, 150.34,  '2002-02-05', '2003-07-10');
INSERT INTO RESERVATION (renter_id, tenant_id, item_leased_id, cost, lease_start, lease_end) VALUES (4, 3, 2,3500.90,  '2007-03-05', '2011-11-20');