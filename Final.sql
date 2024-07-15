drop database if exists final_insurance;
create database final_insurance;
use final_insurance;

CREATE TABLE Insurance_Details (
    Insurance_id varchar(5) PRIMARY KEy,
    Insurance_Name VARCHAR(255),
    Type VARCHAR(255),
    PremiumStart DATE,
    PremiumEnd DATE,
    MinPeriod INT,
    MaxPeriod INT,
    LaunchDate DATE,
    Status VARCHAR(10)
    
);
CREATE TABLE Insurance_Plans (
    Plan_id INT AUTO_INCREMENT PRIMARY KEY,
    Insurance_id  varchar(5),
    Premium_Amount DECIMAL(10, 2),
    Coverage_Amount DECIMAL(10, 2),
    Benefits varchar(369),
    FOREIGN KEY (Insurance_id) REFERENCES Insurance_Details(Insurance_id)
    );
    
    INSERT INTO Insurance_Details (Insurance_id, Insurance_Name, Type, PremiumStart, PremiumEnd, MinPeriod, MaxPeriod, LaunchDate, Status)
VALUES
    ('I001', 'Aditya Birla Activ Health Platinum Plan', 'Private', '2023-01-01', '2023-12-31', 1, 10, '2023-01-01', 'Active'),
    ('I002', 'Bharti AXA Smart Super Health Insurance Policy', 'Government', '2023-03-15', '2024-03-15', 1, 5, '2023-03-15', 'Active'),
    ('I003', 'Niva Bupa Heartbeat Health Insurance Plan', 'Private', '2023-02-01', '2033-02-01', 5, 30, '2023-02-01', 'Active'),
    ('I004', 'Max Bupa Health Companion Individual', 'Private', '2023-04-05', '2024-04-05', 2, 15, '2023-04-05', 'Active'),
	('I005', 'LIC Jeevan Arogya Health Insurance', 'Government', '2023-06-10', '2024-06-10', 3, 20, '2023-06-10', 'Active'),
	('I006', 'HDFC ERGO Health Suraksha Gold Plan', 'Private', '2023-05-20', '2024-05-20', 2, 12, '2023-05-20', 'Active'),
	('I007', 'ICICI Lombard Complete Health Insurance', 'Private', '2023-07-03', '2024-07-03', 4, 25, '2023-07-03', 'Active'),
	('I008', 'New India Assurance Senior Citizen Mediclaim Policy', 'Government', '2023-08-12', '2024-08-12', 6, 35, '2023-08-12', 'Active'),
    ('I009', 'Star Health Family Health Optima Insurance', 'Private', '2023-09-25', '2024-09-25', 3, 18, '2023-09-25', 'Active'),
	('I010', 'Apollo Munich Optima Restore Health Insurance', 'Private', '2023-11-08', '2024-11-08', 5, 28, '2023-11-08', 'Active'),
	('I011', 'SBI Health Insurance Arogya Premier Policy', 'Government', '2023-10-12', '2024-10-12', 4, 22, '2023-10-12', 'Active'),
	('I012', 'Religare Health Insurance Care Freedom Plan', 'Private', '2023-12-15', '2024-12-15', 2, 14, '2023-12-15', 'Active'),
	('I013', 'United India Insurance Platinum Policy', 'Government', '2023-11-30', '2024-11-30', 5, 30, '2023-11-30', 'Active'),
	('I014', 'Max Life Health Insurance ProActive Plan', 'Private', '2023-12-05', '2024-12-05', 3, 20, '2023-12-05', 'Active'),
	('I015', 'Kotak Mahindra Health Premier Plan', 'Private', '2023-12-20', '2024-12-20', 4, 25, '2023-12-20', 'Active'),
	('I016', 'Reliance General Insurance Wellness Plan', 'Private', '2024-01-10', '2025-01-10', 2, 15, '2024-01-10', 'Active'),
	('I017', 'New India Assurance Aashirwad Plan', 'Government', '2024-02-15', '2025-02-15', 5, 28, '2024-02-15', 'Active'),
	('I018', 'LIC Health Protection Plus Policy', 'Government', '2024-03-20', '2025-03-20', 6, 35, '2024-03-20', 'Active'),
    ('I019', 'Bajaj Allianz Health Guard Insurance', 'Private', '2024-04-12', '2025-04-12', 3, 22, '2024-04-12', 'Active'),
	('I020', 'Tata AIG MediCare Premier Plan', 'Private', '2024-05-08', '2025-05-08', 4, 27, '2024-05-08', 'Active'),
	('I021', 'Oriental Insurance Happy Family Floater', 'Government', '2024-06-15', '2025-06-15', 5, 30, '2024-06-15', 'Active'),
	('I022', 'HDFC ERGO Health Optima Restore Plan', 'Private', '2024-07-20', '2025-07-20', 2, 18, '2024-07-20', 'Active'),
	('I023', 'ICICI Prudential Health Saver Policy', 'Private', '2024-08-25', '2025-08-25', 6, 32, '2024-08-25', 'Active'),
    ('I024', 'Star Health Comprehensive Plan', 'Private', '2024-09-10', '2025-09-10', 4, 24, '2024-09-10', 'Active'),
	('I025', 'SBI Health Insurance Arogya Top-Up Policy', 'Government', '2024-10-15', '2025-10-15', 3, 19, '2024-10-15', 'Active'),
	('I026', 'Kotak Mahindra Health Premier Plus Plan', 'Private', '2024-11-20', '2025-11-20', 5, 28, '2024-11-20', 'Active'),
	('I027', 'Max Life Health Insurance ProActive Super Plan', 'Private', '2024-12-25', '2025-12-25', 6, 30, '2024-12-25', 'Active'),
	('I028', 'Reliance General Insurance Care Freedom Plus Plan', 'Private', '2025-01-05', '2026-01-05', 4, 23, '2025-01-05', 'Active'),
	('I029', 'Tata AIG MediCare Premier Plus Plan', 'Private', '2025-02-10', '2026-02-10', 3, 18, '2025-02-10', 'Active'),
	('I030', 'Oriental Insurance Happy Family Floater Gold Plan', 'Government', '2025-03-15', '2026-03-15', 5, 28, '2025-03-15', 'Active'),
	('I031', 'HDFC ERGO Health Optima Vital Plan', 'Private', '2025-04-20', '2026-04-20', 2, 16, '2025-04-20', 'Active'),
	('I032', 'ICICI Prudential Health Saver Gold Policy', 'Private', '2025-05-25', '2026-05-25', 6, 35, '2025-05-25', 'Active'),
	('I033', 'Bajaj Allianz Health Guard Platinum Plan', 'Private', '2025-06-30', '2026-06-30', 4, 26, '2025-06-30', 'Active'),
    ('I034', 'United India Insurance Platinum Plus Policy', 'Government', '2025-07-05', '2026-07-05', 5, 31, '2025-07-05', 'Active'),
	('I035', 'New India Assurance Senior Citizen Mediclaim Gold Plan', 'Government', '2025-08-10', '2026-08-10', 6, 36, '2025-08-10', 'Active'),
	('I036', 'Max Bupa Health Recharge Plan', 'Private', '2025-09-15', '2026-09-15', 3, 20, '2025-09-15', 'Active'),
	('I037', 'Apollo Munich Easy Health Standard Plan', 'Private', '2025-10-20', '2026-10-20', 4, 25, '2025-10-20', 'Active'),
	('I038', 'SBI Health Insurance Arogya Plus Policy', 'Government', '2025-11-25', '2026-11-25', 5, 28, '2025-11-25', 'Active'),
	('I039', 'ICICI Lombard Health Care Plus Insurance', 'Private', '2025-12-30', '2026-12-30', 2, 15, '2025-12-30', 'Active'),
	('I040', 'Religare Health Insurance Enhance Plan', 'Private', '2026-01-05', '2027-01-05', 6, 34, '2026-01-05', 'Active');
    
    select * from insurance_details;
    
    -- Claim and provider---
    
    
    create table claim(
    Claim_Id int Auto_Increment Primary Key	,
    Insurance_id varchar(5),
    Plan_id int,
    Patient_id varchar(100),
    Hospital_id varchar(15),
    Admit_date date,
    disc_date date,
    Bill_Amount numeric(11,2),
    Mis_Amount numeric(9,2),
    Disease varchar(100),
    Comments varchar(100)
    );
     
   
    
    INSERT INTO Insurance_Plans (Insurance_id, Premium_Amount, Coverage_Amount, Benefits)
VALUES

    ('I001', 100, 10000, 'Dental Care'),
    ('I001',989, 30000, 'Maternity Care'),
	('I001', 300, 200000, 'Surgery'),
     
	('I002', 1000.00, 100000.00, 'Hospitalization'),
    ('I002', 200, 7500.00, 'Prescription Drugs'),
	('I002', 800, 150000.00, 'Emergency Room'),
     
	('I003', 600, 20000.00, 'Mental Health Services'),
    ('I003', 1200, 300000, 'Home Healthcare'),
	('I003', 800, 20000, 'Chiropractic Care'),
     
	('I004', 500, 25000.00, 'Vision Care'),
	('I004', 300, 15000.00, 'Physical Therapy'),
	('I004', 700, 35000.00, 'Diagnostic Tests'),

	('I005', 200, 8000.00, 'Ambulance Services'),
	('I005', 400, 20000.00, 'Specialist Consultations'),
	('I005', 600, 30000.00, 'Outpatient Services'),

	('I006', 150, 6000.00, 'Durable Medical Equipment'),
	('I006', 250, 10000.00, 'Urgent Care Visits'),
	('I006', 350, 15000.00, 'Radiology Services'),
	
    ('I007', 700, 35000.00, 'Dialysis Coverage'),
	('I007', 400, 20000.00, 'Rehabilitation Services'),
	('I007', 600, 30000.00, 'Prescription Eyewear'),

	('I008', 300, 12000.00, 'Wellness Programs'),
	('I008', 500, 20000.00, 'Preventive Care'),
	('I008', 900, 36000.00, 'Medical Tourism Coverage'),
	
    ('I009', 200, 8000.00, 'Allergy Testing'),
	('I009', 400, 16000.00, 'Alternative Medicine'),
	('I009', 600, 24000.00, 'Smoking Cessation Programs'),
	
    ('I010', 350, 14000.00, 'Sleep Disorder Treatments'),
	('I010', 550, 22000.00, 'Weight Loss Programs'),
    ('I010', 560, 25000.00, 'Eye-Checkup Programs'),
    
    ('I011', 250, 10000.00, 'Dental Cleanings'),
	('I011', 180, 7200.00, 'X-Ray Services'),
	('I011', 320, 12800.00, 'Orthodontic Treatment'),
	
    ('I012', 450, 18000.00, 'Physical Examinations'),
	('I012', 270, 10800.00, 'Hearing Tests'),
	('I012', 380, 15200.00, 'Podiatry Services'),

	('I013', 210, 8400.00, 'Nutritional Counseling'),
	('I013', 290, 11600.00, 'Speech Therapy'),
	('I013', 410, 16400.00, 'Prenatal Care'),
	
    ('I014', 190, 7600.00, 'Telemedicine Services'),
	('I014', 330, 13200.00, 'Cardiac Rehabilitation'),
	('I014', 280, 11200.00, 'Blood Tests'),

	('I015', 360, 14400.00, 'Occupational Therapy'),
	('I015', 430, 17200.00, 'Home Infusion Therapy'),
	('I015', 260, 10400.00, 'Dietitian Services'),

	('I016', 490, 19600.00, 'Child Vaccinations'),
	('I016', 370, 14800.00, 'Electrocardiograms (ECGs)'),
	('I016', 310, 12400.00, 'Pulmonary Function Tests'),
    
    ('I017', 420, 16800.00, 'Prostate Cancer Screenings'),
	('I017', 200, 8000.00, 'Bone Density Tests'),
    ('I017',340,1000.00, 'Cataract Detection Tests'),

	('I018', 280, 11200.00, 'Colonoscopies'),
	('I018', 390, 15600.00, 'Mammograms'),
	('I018', 220, 8800.00, 'Prostate-Specific Antigen (PSA) Tests'),
    
	('I019', 320, 12800.00, 'MRIs (Magnetic Resonance Imaging)'),
	('I019', 440, 17600.00, 'CAT Scans (Computerized Axial Tomography)'),
	('I019', 260, 10400.00, 'Ultrasounds'),
    
	('I020', 360, 14400.00, 'Allergy Shots'),
	('I020', 470, 18800.00, 'Lung Function Tests'),
	('I020', 250, 10000.00, 'Bone Marrow Testing'),
	
    ('I021', 290, 11600.00, 'Chemotherapy'),
	('I021', 210, 8400.00, 'Radiation Therapy'),
	('I021', 400, 16000.00, 'Immunotherapy'),
	
    ('I022', 340, 13600.00, 'Psychiatric Care'),
	('I022', 470, 18800.00, 'Substance Abuse Treatment'),
	('I022', 280, 11200.00, 'Rehabilitative Services'),
	
    ('I023', 380, 15200.00, 'Acupuncture Therapy'),
	('I023', 260, 10400.00, 'Massage Therapy'),
	('I023', 300, 12000.00, 'Home Health Aide Services'),
	
    ('I024', 230, 9200.00, 'Diabetes Management'),
	('I024', 410, 16400.00, 'Asthma Education'),
	('I024', 330, 13200.00, 'High Blood Pressure Management'),
	
    ('I025', 320, 12800.00, 'Medical Alert Systems'),
	('I025', 480, 19200.00, 'Hearing Aids'),
	('I025', 390, 15600.00, 'Mobility Devices'),
	
    ('I026', 310, 12400.00, 'Dental Fillings'),
	('I026', 240, 9600.00, 'Root Canals'),
	('I026', 370, 14800.00, 'Tooth Extractions'),
    
    ('I027', 270, 10800.00, 'Gastrointestinal Endoscopy'),
	('I027', 410, 16400.00, 'Arthroscopy'),
	('I027', 350, 14000.00, 'Colonoscopy'),
	
    ('I028', 420, 16800.00, 'Cardiac Catheterization'),
	('I028', 320, 12800.00, 'Laparoscopy'),
	('I028', 470, 18800.00, 'Hysterectomy'),
	
    ('I029', 380, 15200.00, 'Cataract Surgery'),
	('I029', 290, 11600.00, 'LASIK Eye Surgery'),
	('I029', 340, 13600.00, 'Dental Implants'),
	
    ('I030', 270, 10800.00, 'In Vitro Fertilization (IVF)'),
	('I030', 450, 18000.00, 'Bariatric Surgery'),
	('I030', 300, 12000.00, 'Chemical Peel'),
	
    ('I031', 410, 16400.00, 'Breast Augmentation'),
	('I031', 350, 14000.00, 'Rhinoplasty'),
	('I031', 480, 19200.00, 'Liposuction'),

	('I032', 310, 12400.00, 'Physical Rehabilitation Therapy'),
	('I032', 470, 18800.00, 'Prosthetic Devices'),
	('I032', 240, 9600.00, 'Wheelchair Accessories'),
	
    ('I033', 380, 15200.00, 'Diabetic Supplies'),
	('I033', 290, 11600.00, 'Breast Pumps'),
	('I033', 330, 13200.00, 'Ostomy Supplies'),
	
    ('I034', 260, 10400.00, 'Pap Smears'),
	('I034', 420, 16800.00, 'Mole Removal'),
	('I034', 370, 14800.00, 'Skin Biopsy'),
	
    ('I035', 400, 16000.00, 'In-Home Care Services'),
	('I035', 300, 12000.00, 'Medical Alert Systems'),
	('I035', 350, 14000.00, 'House Call Visits'),
	
    ('I036', 230, 9200.00, 'Genetic Testing'),
	('I036', 280, 11200.00, 'DNA Testing'),
	('I036', 320, 12800.00, 'Paternity Testing'),
	
    ('I037', 270, 10800.00, 'Blood Pressure Monitoring Device'),
	('I037', 450, 18000.00, 'Sleep Apnea Machine'),
	('I037', 370, 14800.00, 'Glucose Meter'),
	
    ('I038', 380, 15200.00, 'In-Home Nursing Care'),
	('I038', 260, 10400.00, 'Wound Care'),
	('I038', 300, 12000.00, 'IV Therapy'),
	
    ('I039', 320, 12800.00, 'Health Coaching'),
	('I039', 290, 11600.00, 'Stress Management Counseling'),
	('I039', 340, 13600.00, 'Smoking Cessation Counseling'),
	
    ('I040', 390, 15600.00, 'Massage Therapy'),
	('I040', 360, 14400.00, 'Physical Therapy'),
	('I040', 400, 16000.00, 'Occupational Therapy');

    select * from insurance_plans;
    
    
    CREATE TABLE Subscriptions (
    uhid varchar(10),
    Subscription_Id INT AUTO_INCREMENT PRIMARY KEY,
    Plan_id INT,
    Insurance_id VARCHAR(5),
    Premium_Amount DECIMAL(10, 2),
    Coverage_Amount DECIMAL(10, 2),
    PayMode VARCHAR(20),
    email varchar(30),
    RegistrationDate DATE,
    Initial_Amount DECIMAL(10, 2),
    FOREIGN KEY (Insurance_id) REFERENCES Insurance_Details(Insurance_id),
    Status VARCHAR(20),
    dob DATE
);

INSERT INTO Subscriptions (uhid,Plan_id, Insurance_id, Premium_Amount, Coverage_Amount, PayMode, email, RegistrationDate, Initial_Amount, Status,dob)
VALUES
('IN001',1, 'I001', 500.00, 100000.00, 'Monthly', 'john.doe@example.com', '2023-01-15', 1000.00, 'Active','1998-08-25'),
('IN002',2, 'I001', 750.00, 150000.00, 'Quarterly', 'jane.smith@example.com', '2023-02-20', 1200.00, 'Inactive','1999-07-15'),
('IN003',3, 'I002', 600.00, 120000.00, 'Annual', 'bob.jones@example.com', '2023-03-10', 800.00, 'Active','1980-10-21'),
('IN004',4, 'I002', 550.00, 110000.00, 'Monthly', 'alice.white@example.com', '2023-04-05', 900.00, 'Inactive','1979-04-15'),
('IN005',5, 'I002', 800.00, 160000.00, 'Quarterly', 'sam.green@example.com', '2023-05-12', 1300.00, 'Active','1983-06-28'),
('IN006',6, 'I002', 650.00, 130000.00, 'Annual', 'emily.jones@example.com', '2023-06-18', 950.00, 'Inactive','1986-11-22'),
('IN007',7, 'I003', 700.00, 140000.00, 'Monthly', 'david.smith@example.com', '2023-07-22', 1100.00, 'Active','1999-08-25'),
('IN008',8, 'I003', 850.00, 170000.00, 'Quarterly', 'olivia.white@example.com', '2023-08-30', 1400.00, 'Inactive','1984-02-15'),
('IN009',9, 'I003', 750.00, 150000.00, 'Annual', 'charlie.green@example.com', '2023-09-14', 1000.00, 'Active','1999-08-25'),
('IN010',10, 'I004', 600.00, 120000.00, 'Monthly', 'lucy.jones@example.com', '2023-10-03', 800.00, 'Inactive','1969-01-14'),
('IN011',11, 'I004', 900.00, 180000.00, 'Quarterly', 'mike.doe@example.com', '2023-11-08', 1500.00, 'Active','1999-08-25'),
('IN012',12, 'I004', 700.00, 140000.00, 'Annual', 'sophie.smith@example.com', '2023-12-19', 950.00, 'Inactive','1989-03-12'),
('IN013',13, 'I004', 650.00, 130000.00, 'Monthly', 'max.green@example.com', '2024-01-25', 900.00, 'Active','1996-07-18'),
('IN014',14, 'I005', 950.00, 190000.00, 'Quarterly', 'ava.jones@example.com', '2024-02-11', 1600.00, 'Inactive','1992-09-25'),
('IN015',15, 'I005', 800.00, 160000.00, 'Annual', 'noah.white@example.com', '2024-03-07', 1100.00, 'Active','1991-09-22'),
('IN016',16, 'I006', 750.00, 150000.00, 'Monthly', 'mia.smith@example.com', '2024-04-14', 1200.00, 'Inactive','1990-08-28'),
('IN017',17, 'I006', 1000.00, 200000.00, 'Quarterly', 'ethan.doe@example.com', '2024-05-20', 1700.00, 'Active','1982-06-25'),
('IN018',18, 'I007', 850.00, 170000.00, 'Annual', 'ava.green@example.com', '2024-06-02', 1300.00, 'Inactive','1980-08-19'),
('IN019',19, 'I008', 800.00, 160000.00, 'Monthly', 'oliver.jones@example.com', '2024-07-09', 1100.00, 'Active','1978-09-20'),
('IN020',20, 'I009', 1050.00, 210000.00, 'Quarterly', 'emma.white@example.com', '2024-08-16', 1800.00, 'Inactive','1977-05-23'),
('IN021',21, 'I010', 900.00, 180000.00, 'Monthly', 'liam.smith@example.com', '2024-09-23', 1500.00, 'Active','1963-07-21'),
('IN022',22, 'I010', 800.00, 160000.00, 'Annual', 'ava.jones@example.com', '2024-10-30', 1300.00, 'Inactive','1965-08-13'),
('IN023',23, 'I010', 750.00, 150000.00, 'Monthly', 'noah.green@example.com', '2024-11-05', 1200.00, 'Active','1966-02-16'),
('IN024',24, 'I011', 1100.00, 220000.00, 'Quarterly', 'olivia.doe@example.com', '2024-12-12', 1900.00, 'Inactive','1968-01-11'),
('IN025',25, 'I012', 950.00, 190000.00, 'Quarterly', 'emma.jones@example.com', '2025-01-18', 1600.00, 'Active','1968-01-11'),
('IN026',25, 'I012', 850.00, 200000.00, 'Monthly', 'emmile.jon@example.com', '2026-02-17', 2600.00, 'Inactive','1970-02-15');
 select * from Subscriptions;
UPDATE Subscriptions
SET dob =
  CASE
    WHEN Subscription_Id = 11 THEN '1999-08-25'
    WHEN Subscription_Id = 12 THEN '1989-03-12'
    WHEN Subscription_Id = 13 THEN '1996-07-18'
    WHEN Subscription_Id = 14 THEN '1992-09-25'
	WHEN Subscription_Id = 15 THEN '1991-09-22'
	WHEN Subscription_Id = 16 THEN '1990-08-28'
	WHEN Subscription_Id = 17 THEN '1982-06-25'
	WHEN Subscription_Id = 18 THEN '1980-08-19' 
	WHEN Subscription_Id = 19 THEN '1978-09-20'
    WHEN Subscription_Id = 20 THEN '1977-05-23'
    WHEN Subscription_Id = 21 THEN '1963-07-21'
    WHEN Subscription_Id = 22 THEN '1965-08-13'
    WHEN Subscription_Id = 23 THEN '1966-02-16'
    WHEN Subscription_Id = 24 THEN '1968-01-11'
    WHEN Subscription_Id = 25 THEN '1968-01-11'
     
  END
WHERE Subscription_Id IN (21, 22, 23, 24, 25);

drop table if exists Subscriptions;

CREATE TABLE Insurance_Plans (
    Plan_id INT AUTO_INCREMENT PRIMARY KEY,
    Insurance_id  varchar(5),
    Premium_Amount DECIMAL(10, 2),
    Coverage_Amount DECIMAL(10, 2),
    diseases_covered varchar(369),
    FOREIGN KEY (Insurance_id) REFERENCES Insurance_Details(Insurance_id)
    );
    
    INSERT INTO Insurance_Plans (Insurance_id, Premium_Amount, Coverage_Amount, diseases_covered)
VALUES
    ('I001', 100, 10000, 'Dental Care'),
    ('I001',989, 30000, 'Maternity Care'),
     ('I001', 300, 200000, 'Surgery'),
     
       ('I002', 1000.00, 100000.00, 'Hospitalization'),
    ('I002', 200, 7500.00, 'Prescription Drugs'),
     ('I002', 800, 150000.00, 'Emergency Room'),
     
       ('I003', 600, 20000.00, 'Mental Health Services'),
    ('I003', 1200, 300000, 'Home Healthcare'),
     ('I003', 800, 20000, 'Chiropractic Care'),
     
     ('I004', 500, 25000.00, 'Vision Care'),
	('I004', 300, 15000.00, 'Physical Therapy'),
	('I004', 700, 35000.00, 'Diagnostic Tests'),

	('I005', 200, 8000.00, 'Ambulance Services'),
	('I005', 400, 20000.00, 'Specialist Consultations'),
	('I005', 600, 30000.00, 'Outpatient Services'),

	('I006', 150, 6000.00, 'Durable Medical Equipment'),
	('I006', 250, 10000.00, 'Urgent Care Visits'),
	('I006', 350, 15000.00, 'Radiology Services'),
	
    ('I007', 700, 35000.00, 'Dialysis Coverage'),
	('I007', 400, 20000.00, 'Rehabilitation Services'),
	('I007', 600, 30000.00, 'Prescription Eyewear'),

	('I008', 300, 12000.00, 'Wellness Programs'),
	('I008', 500, 20000.00, 'Preventive Care'),
	('I008', 900, 36000.00, 'Medical Tourism Coverage'),
	
    ('I009', 200, 8000.00, 'Allergy Testing'),
	('I009', 400, 16000.00, 'Alternative Medicine'),
	('I009', 600, 24000.00, 'Smoking Cessation Programs'),
	
    ('I010', 350, 14000.00, 'Sleep Disorder Treatments'),
	('I010', 550, 22000.00, 'Weight Loss Programs'),
    ('I010', 560, 25000.00, 'Eye-Checkup Programs'),
    
    ('I011', 250, 10000.00, 'Dental Cleanings'),
	('I011', 180, 7200.00, 'X-Ray Services'),
	('I011', 320, 12800.00, 'Orthodontic Treatment'),
	
    ('I012', 450, 18000.00, 'Physical Examinations'),
	('I012', 270, 10800.00, 'Hearing Tests'),
	('I012', 380, 15200.00, 'Podiatry Services'),

	('I013', 210, 8400.00, 'Nutritional Counseling'),
	('I013', 290, 11600.00, 'Speech Therapy'),
	('I013', 410, 16400.00, 'Prenatal Care'),
	
    ('I014', 190, 7600.00, 'Telemedicine Services'),
	('I014', 330, 13200.00, 'Cardiac Rehabilitation'),
	('I014', 280, 11200.00, 'Blood Tests'),

	('I015', 360, 14400.00, 'Occupational Therapy'),
	('I015', 430, 17200.00, 'Home Infusion Therapy'),
	('I015', 260, 10400.00, 'Dietitian Services'),

	('I016', 490, 19600.00, 'Child Vaccinations'),
	('I016', 370, 14800.00, 'Electrocardiograms (ECGs)'),
	('I016', 310, 12400.00, 'Pulmonary Function Tests'),
    
    ('I017', 420, 16800.00, 'Prostate Cancer Screenings'),
	('I017', 200, 8000.00, 'Bone Density Tests'),
    ('I017',340,1000.00, 'Cataract Detection Tests'),

	('I018', 280, 11200.00, 'Colonoscopies'),
	('I018', 390, 15600.00, 'Mammograms'),
	('I018', 220, 8800.00, 'Prostate-Specific Antigen (PSA) Tests'),
    
	('I019', 320, 12800.00, 'MRIs (Magnetic Resonance Imaging)'),
	('I019', 440, 17600.00, 'CAT Scans (Computerized Axial Tomography)'),
	('I019', 260, 10400.00, 'Ultrasounds'),
    
	('I020', 360, 14400.00, 'Allergy Shots'),
	('I020', 470, 18800.00, 'Lung Function Tests'),
	('I020', 250, 10000.00, 'Bone Marrow Testing'),
	
    ('I021', 290, 11600.00, 'Chemotherapy'),
	('I021', 210, 8400.00, 'Radiation Therapy'),
	('I021', 400, 16000.00, 'Immunotherapy'),
	
    ('I022', 340, 13600.00, 'Psychiatric Care'),
	('I022', 470, 18800.00, 'Substance Abuse Treatment'),
	('I022', 280, 11200.00, 'Rehabilitative Services'),
	
    ('I023', 380, 15200.00, 'Acupuncture Therapy'),
	('I023', 260, 10400.00, 'Massage Therapy'),
	('I023', 300, 12000.00, 'Home Health Aide Services'),
	
    ('I024', 230, 9200.00, 'Diabetes Management'),
	('I024', 410, 16400.00, 'Asthma Education'),
	('I024', 330, 13200.00, 'High Blood Pressure Management'),
	
    ('I025', 320, 12800.00, 'Medical Alert Systems'),
	('I025', 480, 19200.00, 'Hearing Aids'),
	('I025', 390, 15600.00, 'Mobility Devices'),
	
    ('I026', 310, 12400.00, 'Dental Fillings'),
	('I026', 240, 9600.00, 'Root Canals'),
	('I026', 370, 14800.00, 'Tooth Extractions'),
    
    ('I027', 270, 10800.00, 'Gastrointestinal Endoscopy'),
	('I027', 410, 16400.00, 'Arthroscopy'),
	('I027', 350, 14000.00, 'Colonoscopy'),
	
    ('I028', 420, 16800.00, 'Cardiac Catheterization'),
	('I028', 320, 12800.00, 'Laparoscopy'),
	('I028', 470, 18800.00, 'Hysterectomy'),
	
    ('I029', 380, 15200.00, 'Cataract Surgery'),
	('I029', 290, 11600.00, 'LASIK Eye Surgery'),
	('I029', 340, 13600.00, 'Dental Implants'),
	
    ('I030', 270, 10800.00, 'In Vitro Fertilization (IVF)'),
	('I030', 450, 18000.00, 'Bariatric Surgery'),
	('I030', 300, 12000.00, 'Chemical Peel'),
	
    ('I031', 410, 16400.00, 'Breast Augmentation'),
	('I031', 350, 14000.00, 'Rhinoplasty'),
	('I031', 480, 19200.00, 'Liposuction'),

	('I032', 310, 12400.00, 'Physical Rehabilitation Therapy'),
	('I032', 470, 18800.00, 'Prosthetic Devices'),
	('I032', 240, 9600.00, 'Wheelchair Accessories'),
	
    ('I033', 380, 15200.00, 'Diabetic Supplies'),
	('I033', 290, 11600.00, 'Breast Pumps'),
	('I033', 330, 13200.00, 'Ostomy Supplies'),
	
    ('I034', 260, 10400.00, 'Pap Smears'),
	('I034', 420, 16800.00, 'Mole Removal'),
	('I034', 370, 14800.00, 'Skin Biopsy'),
	
    ('I035', 400, 16000.00, 'In-Home Care Services'),
	('I035', 300, 12000.00, 'Medical Alert Systems'),
	('I035', 350, 14000.00, 'House Call Visits'),
	
    ('I036', 230, 9200.00, 'Genetic Testing'),
	('I036', 280, 11200.00, 'DNA Testing'),
	('I036', 320, 12800.00, 'Paternity Testing'),
	
    ('I037', 270, 10800.00, 'Blood Pressure Monitoring Device'),
	('I037', 450, 18000.00, 'Sleep Apnea Machine'),
	('I037', 370, 14800.00, 'Glucose Meter'),
	
    ('I038', 380, 15200.00, 'In-Home Nursing Care'),
	('I038', 260, 10400.00, 'Wound Care'),
	('I038', 300, 12000.00, 'IV Therapy'),
	
    ('I039', 320, 12800.00, 'Health Coaching'),
	('I039', 290, 11600.00, 'Stress Management Counseling'),
	('I039', 340, 13600.00, 'Smoking Cessation Counseling'),
	
    ('I040', 390, 15600.00, 'Massage Therapy'),
	('I040', 360, 14400.00, 'Physical Therapy'),
	('I040', 400, 16000.00, 'Occupational Therapy');

select * from insurance_plans;

CREATE TABLE Authentication (
Authid INT AUTO_INCREMENT PRIMARY KEY,
UHID varchar(50),
email varchar(50) not null,
username varchar(50) not null,
name varchar(100),
password varchar(200) not null,
otp varchar(20) not null
 
);
insert into authentication(UHID,email,username,name,password,otp)
values
('IN001','kaushik@gmail.com','kaushik123','Kaushik','Sarkar@2023','675436'),
('IN002','shyam@gmail.com','shyam123','Shyam','shyam123','685436'),
('IN003','him@gmail.com','himanshu','Himanshu','ray','675455'),
('IN004','abhi@gmail.com','abhishek','Abhishek','abhishek','345436');

drop table if exists authentication ;
select * from authentication;
drop table if exists subscriptions;
drop table if exists authentication;
INSERT INTO Subscriptions (uhid,Plan_id, Insurance_id, Premium_Amount, Coverage_Amount, PayMode, email, RegistrationDate, Initial_Amount, Status,dob)
VALUES

('IN001',1,'I001',100.0,1200.00, 'MONTHLY', 'kaushik@gmail.com', '2023-01-15', 100.00, 'INACTIVE','1999-12-20'),
('IN001',2,'I002',400.0,2000.00, 'QUARTERLY','soul@gmail.com', '2023-02-15', 400.00, 'ACTIVE','1999-12-20'),
('IN001',3,'I001',100.0,1500.00,'MONTHLY','frustarte@gmail.com','2024-01-23',500.00,'INACTIVE','1999-12-20'),
('IN001',4,'I004',400.0,4000.00,'QUARTERLY','umang@gmail.com', '2023-04-05', 400.00, 'ACTIVE','1999-12-20'),
('IN001',5,'I005',1500.0,5000.00, 'ANNUALLY', 'kaushik@hotmail.com', '2023-08-10', 1500.00, 'ACTIVE','1999-12-20'),

('IN002',1,'I001',100.0,1200.00,'MONTHLY','him1@gmail.com', '2023-02-03', 100.00, 'INACTIVE','2000-08-16'),
('IN002',6,'I006',600.0,3000.00,'QUARTERLY','him2@gmail.com', '2023-07-20', 1200.00, 'ACTIVE','2000-08-16'),
('IN002',7,'I007',700.0,30000.00,'QUARTERLY','him3@gmail.com', '2023-07-05', 700.00, 'ACTIVE','2000-08-16'),
('IN002',8,'I006',100.0,1000.00,'QUARTERLY','him4@gmail.com', '2023-08-18', 200.00, 'ACTIVE','2000-08-16'),
('IN002',9,'I006',600.0,5000.00,'QUARTERLY','him5@gmail.com', '2023-07-21', 1200.00, 'ACTIVE','2000-08-16'),

('IN003',3,'I003',300.0,4000.00, 'MONTHLY', 'harsh1@rgeyr.com', '2023-02-01', 900.00, 'INACTIVE','2000-08-09'),
('IN003',10,'I002',200.0,3000.00, 'MONTHLY', 'harsh2@rgeyr.com', '2023-04-15', 2000.00, 'ACTIVE','2000-08-09'),
('IN003',11,'I004',400.0,4000.00, 'QUARTERLY', 'harsh3@rgeyr.com', '2023-07-05', 800.00, 'ACTIVE','2000-08-09'),
('IN003',12,'I001',100.0,1800.00, 'MONTHLY', 'harsh4@rgeyr.com', '2023-01-01', 1000.00, 'ACTIVE','2000-08-09'),
('IN003',13,'I008',3000.0,8000.00, 'ANNUALLY', 'harsh5@rgeyr.com', '2023-09-12', 3000.00, 'ACTIVE','2000-08-09'),

('IN004',14,'I005',2000.0,5000.00, 'ANNUALLY', 'abhi1@rgeyr.com', '2023-03-15', 2000.00, 'INACTIVE','2000-09-17'),
('IN004',1,'I001',100.0,1200.00, 'MONTHLY', 'abhi1@rgeyr.com', '2023-03-15', 1000.00, 'INACTIVE','2000-09-17'),
('IN004',10,'I002',200.0,4000.00, 'MONTHLY', 'abhi1@rgeyr.com', '2023-03-15', 1200.00, 'ACTIVE','2000-09-17'),
('IN004',7,'I007',700.0,7000.00, 'QUARTERLY', 'abhi1@rgeyr.com', '2023-03-15', 1400.00, 'ACTIVE','2000-09-17'),
('IN004',8,'I006',600.0,6000.00, 'QUARTERLY', 'abhi1@rgeyr.com', '2023-03-15', 6000.00, 'ACTIVE','2000-09-17'),
('IN004',15,'I003',1500.0,3000.00, 'ANNUALLY', 'abhi1@rgeyr.com', '2023-03-15', 1500.00, 'INACTIVE','2000-09-17'),

('IN005',11,'I004',400.0,4000.00, 'QUARTERLY', 'piyu@rgeyr.com', '2023-06-05', 1200.00, 'ACTIVE','1999-10-23'),
('IN005',12,'I001',100.0,1200.00, 'MONTHLY', 'piyu@rgeyr.com', '2023-01-02', 1200.00, 'ACTIVE','1999-10-23'),
('IN005',15,'I009',300.0,9000.00, 'MONTHLY', 'piyu@rgeyr.com', '2023-10-25', 2500.00, 'INACTIVE','1999-10-23'),
('IN005',20,'I008',800.0,8000.00, 'MONTHLY', 'piyu@rgeyr.com', '2023-12-12', 4000.00, 'ACTIVE','1999-10-23'),
('IN005',7,'I007',200.0,7000.00, 'MONTHLY', 'piyu@rgeyr.com', '2023-10-03', 2000.00, 'ACTIVE','1999-10-23'),

('IN006',2,'I002',200.0,2000.00, 'ANNUALLY', 'piyasa@rgeyr.com', '2023-03-18', 200.00, 'INACTIVE','1980-10-23'),
('IN006',3,'I003',300.0,5000.00, 'MONTHLY', 'piyasa@rgeyr.com', '2023-02-10', 1800.00, 'ACTIVE','1980-10-23'),
('IN006',1,'I001',100.0,1200.00, 'MONTHLY', 'piyasa@rgeyr.com', '2023-01-15', 1000.00, 'ACTIVE','1980-10-23'),
('IN006',10,'I002',200.0,6000.00, 'MONTHLY', 'piyasa@rgeyr.com', '2023-05-29', 2000.00, 'INACTIVE','1980-10-23'),
('IN006',19,'I007',700.0,7000.00, 'QUARTERLY', 'piyasa@rgeyr.com', '2023-07-10', 1400.00, 'ACTIVE','1980-10-23'),
('IN006',20,'I008',2000.0,8000.00, 'ANNUALLY', 'piyasa@rgeyr.com', '2023-08-23', 2000.00, 'INACTIVE','1980-10-23'),

('IN007',16,'I004',400.0,4000.00, 'QUARTERLY', 'tinaa@rgeyr.com', '2023-05-06', 800.00, 'ACTIVE','1980-10-23'),
('IN007',18,'I004',1000.0,4000.00, 'ANNUALLY', 'tinaa@rgeyr.com', '2023-05-07', 1000.00, 'INACTIVE','1980-10-23'),
('IN007',17,'I009',500.0,9000.00, 'MONTHLY', 'tinaa@rgeyr.com', '2023-10-30', 1000.00, 'ACTIVE','1980-10-23'),
('IN007',2,'I002',200.0,3000.00, 'MONTHLY', 'tinaa@rgeyr.com', '2023-03-18', 2200.00, 'INACTIVE','1980-10-23'),
('IN007',1,'I001',100.0,1200.00, 'MONTHLY', 'tinaa@rgeyr.com', '2023-02-05', 1000.00, 'ACTIVE','1980-10-23'),

('IN008',21,'I001',150.0,3500.00,'MONTHLY','anirudh@hotmail.com','2023-01-03',300.00,'ACTIVE','1988-08-22'),
('IN008',24,'I008',800.0,8000.00,'ANNUALLY', 'anirudh@gmail.com','2023-08-12',800.00,'ACTIVE','1988-08-22'),
('IN008',22,'I004',400.0,4000.00,'QUARTERLY', 'ani@reewd.com','2023-05-05',800.00,'ACTIVE','1988-08-22'),
('IN008',25,'I015',7000.0,15000.00,'ANNUALLY', 'ant@gmail.com','2023-12-20',7000.00,'ACTIVE','1988-08-22'),
('IN008',23,'I014',5000.0,14000.00,'ANNUALLY', 'anii@hotmail.com','2023-12-10',5000.00,'ACTIVE','1988-08-22'),

('IN009',1,'I001',100.0,1200.00, 'MONTHLY', 'raju@outlook.com', '2023-01-11', 700.00, 'ACTIVE','1999-12-07'),
('IN009',23,'I017',10000.0,17000.00, 'ANNUALLY', 'raju@gmail.com', '2024-02-15', 10000.00, 'ACTIVE','1999-12-07'),
('IN009',7,'I007',1000.0,7000.00, 'ANNUALLY', 'raju@abcd.com', '2023-10-20', 1000.00, 'ACTIVE','1999-12-07'),
('IN009',8,'I008',1000.0,8000.00, 'ANNUALLY', 'raju@wxyz.com', '2023-12-18', 1000.00, 'ACTIVE','1999-12-07'),
('IN009',3,'I003',2000.0,3000.00, 'ANNUALLY', 'raju@gmail.com', '2023-02-12', 2000.00, 'INACTIVE','1999-12-07'),

('IN010',25,'I014',1400.0,14000.00, 'MONTHLY', 'rohan@outlook.com', '2024-02-15', 1680.00, 'ACTIVE','1999-11-05'),
('IN010',24,'I007',700.0,7000.00, 'QUARTERLY', 'rohan@gmail.com', '2023-08-03', 1400.00, 'ACTIVE','1999-11-05'),
('IN010',2,'I002',200.0,3000.00, 'MONTHLY', 'rohan@outlook.com', '2023-03-22', 2400.00, 'INACTIVE','1999-11-05'),
('IN010',5,'I005',2000.0,5000.00, 'ANNUALLY', 'rohan@gmail.com', '2023-07-15', 2000.00, 'ACTIVE','1999-11-05'),
('IN010',15,'I015',50000.0,150000.00, 'ANNUALLY', 'rohan@hotmail.com', '2023-12-31', 50000.00, 'INACTIVE','1999-11-05'),
('IN010',9,'I009',900.0,9000.00, 'QUARTERLY', 'rohan@gmail.com', '2023-09-30', 1800.00, 'INACTIVE','1999-11-05'),

('IN011',12,'I003',300.0,7200.00, 'MONTHLY', 'ravi@outlook.com', '2023-03-03', 3000.00, 'ACTIVE','2000-11-05'),
('IN011',28,'I005',500.0,8000.00, 'MONTHLY', 'ravi@gmail.com', '2023-07-10', 5500.00, 'ACTIVE','2000-11-05'),
('IN011',1,'I009',200.0,9000.00, 'MONTHLY', 'ravi@outlook.com', '2023-03-28', 2200.00, 'INACTIVE','2000-11-05'),
('IN011',2,'I008',500.0,8000.00, 'MONTHLY', 'ravi1@gmail.com', '2023-10-15', 4800.00, 'ACTIVE','2000-11-05'),
('IN011',29,'I006',600.0,25000.00, 'MONTHLY', 'ravi@hotmail.com', '2023-05-21', 3600.00, 'ACTIVE','2000-11-05'),

('IN012',26,'I003',300.0,5000.00, 'MONTHLY', 'rohan@gmail.com', '2023-03-01', 1500.00, 'ACTIVE','1999-11-20'),
('IN012',1,'I007',700.0,10000.00, 'MONTHLY', 'rohan@outlook.com', '2023-08-03', 6000.00, 'ACTIVE','1999-11-20'),
('IN012',27,'I006',600.0,7000.00, 'QUARTERLY', 'rohan@gmail.com', '2023-05-21', 1800.00, 'ACTIVE','1999-11-20'),
('IN012',2,'I002',200.0,120000.00, 'QUARTERLY', 'rohan@hotmail.com', '2023-04-16', 600.00, 'INACTIVE','1999-11-20'),
('IN012',30,'I008',800.0,14700.00, 'MONTHLY', 'rohan@gmail.com', '2023-10-12', 8400.00, 'ACTIVE','1999-11-20');

select * from subscriptions;