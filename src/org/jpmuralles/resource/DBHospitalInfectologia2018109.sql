create database DBHospitalInfectologia2018109;
use DBHospitalInfectologia2018109;


create table Generos(
	idGenero varchar (45) not null primary key 
	
);

create table Medicos
(
	codigoMedico int (10) primary key auto_increment,
	licenciaMedica int NOT NULL,
	nombres varchar (100) NOT NULL,
	apellidos varchar (100)NOT NULL,
	horaEntrada datetime NOT NULL,
	horaSalida datetime NOT NULL,
    idGenero varchar(45),
   foreign key (idGenero) references Generos(idGenero)
);

DELIMITER $$
create Procedure sp_AgregarGenero (v_idGenero varchar(150))

begin
	insert into Generos (idGenero)
		values(v_idGenero);

end;

call sp_AgregarGenero('Masculino');
call sp_AgregarGenero('Femenino');
call sp_AgregarGenero('Abimegender');
call sp_AgregarGenero('Adamasgender');
call sp_AgregarGenero('Aerogender');
call sp_AgregarGenero('Aesthetigender');
call sp_AgregarGenero('Affectugender');
call sp_AgregarGenero('Agender');
call sp_AgregarGenero('Agenderflux');
call sp_AgregarGenero('Alexigender');
call sp_AgregarGenero('Aliusgender');
call sp_AgregarGenero('Amaregender');
call sp_AgregarGenero('Ambigender');
call sp_AgregarGenero('Ambonec');
call sp_AgregarGenero('Amicagender');
call sp_AgregarGenero('Andrógino');
call sp_AgregarGenero('Anesigender');
call sp_AgregarGenero('Angenital');
call sp_AgregarGenero('Anogender');
call sp_AgregarGenero('Anongender');
call sp_AgregarGenero('Antegender');
call sp_AgregarGenero('Anxiegender');
call sp_AgregarGenero('Apagender');
call sp_AgregarGenero('Apconsugender');
call sp_AgregarGenero('Astergender');
call sp_AgregarGenero('Astralgender');
call sp_AgregarGenero('Autigender');
call sp_AgregarGenero('Autogender');

delimiter $$
create Procedure sp_Mostrargenero ()
begin
select * from Generos;
end;
call sp_MostrarGenero;


DELIMITER $$
create Procedure sp_AgregarMedicos (in v_licenciaMedica int, v_nombres varchar(100), v_apellidos varchar(100), v_horaEntrada datetime, v_horaSalida datetime,  v_idGenero varchar(45))

begin
	insert into Medicos (licenciaMedica, nombres, apellidos, horaEntrada, horaSalida,  idGenero)
		values( v_licenciaMedica, v_nombres, v_apellidos, v_horaEntrada, v_horaSalida, v_idGenero);

end;
    
call sp_AgregarMedicos(651941,'Juan Pablo','Muralles','2019-02-02','2019-02-03','Masculino');
call sp_AgregarMedicos(154294,'Daniela','López','2019-02-02','2019-02-03','Femenino');
call sp_AgregarMedicos(135249,'Hector','Mazariegos','2019-02-02','2019-02-03','Masculino');
call sp_AgregarMedicos(487916,'Javier','Herrera','2019-02-02','2019-02-03','Anogender');
call sp_AgregarMedicos(487916,'Gerardo','Ortiz','2019-02-02','2019-02-03','Angenital');


delimiter $$
create Procedure sp_MostrarMedicos ()
begin
select codigoMedico, licenciaMedica, nombres, apellidos, horaEntrada, horaSalida, idGenero from Medicos;
end;
	
call sp_MostrarMedicos


delimiter $$
create procedure sp_EditarMedicos(in v_codigoMedico int , v_licenciaMedica int, v_nombres varchar(100), v_apellidos varchar(100), v_horaEntrada datetime, v_horaSalida datetime,  v_idGenero varchar(45))
begin
	update Medicos
    set licenciaMedica = v_licenciaMedica, nombres = v_nombres, apellidos = v_apellidos, horaEntrada = v_horaEntrada, horaSalida = v_horaSalida, idGenero = v_idGenero
    where codigoMedico = v_codigomedico;
    
end$$

delimiter $$
create procedure sp_buscarMedicos(in v_codigoMedico int , v_licenciaMedica int, v_nombres varchar(100), v_apellidos varchar(100), v_horaEntrada datetime, v_horaSalida datetime,  v_idGenero varchar(45))
begin
select codigoMedico, licenciaMedica, nombres, apellidos, horaEntrada, horaSalida, idGenero from Medicos where codigoMedico = v_codigoMedico;
end $$

delimiter $$
create procedure sp_buscarGeneros( v_idGenero varchar(45))
begin
select idGenero from Generos where idGenero = v_idGenero;
end $$

