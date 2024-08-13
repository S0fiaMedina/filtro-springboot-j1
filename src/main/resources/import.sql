INSERT INTO modeadministration(descriptionmode) VALUES ('Via oral');
INSERT INTO unitmeasurement(nameum) VALUES ('ml');
INSERT INTO activeprinciple(nameap) VALUES ('xxxx');


-- locacion
INSERT INTO country(codecountry,namecountry) VALUES ('COL', 'Colombia');
INSERT INTO region(codereg,namereg, codecountry) VALUES ('STN', 'Santander', 'COL');
INSERT INTO city(codecity,namecity, codereg) VALUES ('BGA', 'Bucaramanga', 'STN');
INSERT INTO laboratory(namelab,codecityreg) VALUES ('LAB S.A', 'BGA');
INSERT INTO farmacy(namefarmacy,addressfarmacy, logofarmacy, longfarmacy, lat, codecityfarm) VALUES ('Farmatodo s.a', 'Calle 56 #33-34, Real de minas', 'farmacy.png', 111, 222, 'BGA');

-- MEDICINA
INSERT INTO medicine(proceedings,namemedicine, healthregister, description, descriptionshort, namerol, codeadminmode, codeap, codeum, codelab) VALUES ('xxxx', 'acetaminofen', 'ewree3w21', 'medicina para la fiebre', 'medicina', 'ROL', 1, 1,1,1 );
INSERT INTO farmacymedicine(idfarmacy,idmedicine, price) VALUES (1, 1,500);