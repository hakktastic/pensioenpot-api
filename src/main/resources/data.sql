-- Insert dienstverband first
INSERT INTO dienstverband (id, dienstverband_reference, salaris, part_time_percentage)
VALUES (1, '22222222-0000-0000-0000-000000000001', 60000.00, 0.8);

-- Insert deelnemer linked to dienstverband (id must match dienstverband.id)
INSERT INTO deelnemer (id, deelnemer_reference, naam, email, geboortedatum)
VALUES (1, '11111111-0000-0000-0000-000000000001', 'Jan Test', 'jan.test@example.com', CURRENT_DATE - INTERVAL '60 years');

-- Insert pensioen_regeling linked to deelnemer (id must match deelnemer.id)
INSERT INTO pensioen_regeling (id, pensioen_regeling_reference, franchise, beschikbare_premie_percentage, beleggingsrekening_references)
VALUES (1, '33333333-0000-0000-0000-000000000001', 15599.00, 0.05, 'NL91ABNA0417164300');