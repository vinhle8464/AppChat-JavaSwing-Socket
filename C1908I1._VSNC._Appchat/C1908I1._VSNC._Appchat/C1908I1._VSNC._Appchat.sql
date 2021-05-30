create database eprojectJava
go 


use eprojectJava

create table account
(
    id_acc int IDENTITY PRIMARY KEY,
    account VARCHAR(20),
    pass VARCHAR(200),
    fullname NVARCHAR(50),
    dob date,
    gender varchar(6),
    phonenumber VARCHAR(15),
    email VARCHAR(50),
    addr NVARCHAR(200),
    date_create varchar(50), 
    classify char(1),
    status_acc CHAR(1),	
	img image,
    active_status char(1)
)


create table privateMessage 
(
 id_mess int IDENTITY PRIMARY KEY,
    id_acc int,
    mess NVARCHAR(1000),
    time_send varchar(20),
    account_one VARCHAR(50),
    account_two VARCHAR(50),
    status_mess char(1),


)

create table chatport
(
    id_chatport int IDENTITY PRIMARY KEY,
    account_one varchar(20),
    account_two varchar(20),
    status_join_one char(1),
    status_join_two char(1),
    portchat varchar(5)
)

create table roomChat
(
    id_room int IDENTITY PRIMARY KEY,
    name_room NVARCHAR(50),
    status_room char(1),
    portroom varchar(5)
)

create table roomMember
(
    id_room int,
    id_acc int,
    mess NVARCHAR(1000),
    time_send date,
    status_member char(1),
    PRIMARY KEY(id_room, id_acc)
	
)

create table FriendChat
(
    id_friend int IDENTITY PRIMARY KEY,
    id_acc int,
    account_one varchar(50),
    account_two varchar(50),
    status_friend_one char(1),
    status_friend_two char(1)
)



alter table privateMessage
add CONSTRAINT FK_privateMessage_account
 FOREIGN KEY (id_acc) REFERENCES account(id_acc);

alter table roomMember
add CONSTRAINT FK_roomMember_account
FOREIGN KEY(id_acc) REFERENCES account(id_acc)

alter table roomMember 
add CONSTRAINT FK_roomMember_roomChat
FOREIGN KEY(id_room) REFERENCES roomChat(id_room)

alter table FriendChat
add CONSTRAINT FK_FrienChat_account
FOREIGN KEY(id_acc) REFERENCES account(id_acc) 



create proc insAcc
@fullname nvarchar(50),@account nvarchar(50),@email varchar(50),@pass varchar(200),@classify char(1),@dob date,@status_acc CHAR(1),@img image,@date_create VARCHAR(50)
as
begin
	insert into account(fullname,account,email,pass,classify,dob,status_acc,img,date_create) values (@fullname,@account,@email,@pass,@classify,@dob,@status_acc,@img,@date_create) 
end
go

create proc selAcc
@account nvarchar(50)
as
begin
	select id_acc, account,pass,classify, img from account where account = @account
end
go

create proc UpInfoAcc
@fullname nvarchar(50),@dob date,@gender varchar(6),@phonenumber varchar(15),@email varchar(50),@addr nvarchar(200), @img image ,@account nvarchar(50) 
as
begin 
		
		update Account set fullname = @fullname ,dob = @dob ,gender = @gender,phonenumber = @phonenumber,email = @email,addr = @addr , img=@img  where account = @account

end
go

create proc ChangePass
@pass varchar(200) , @account nvarchar(50)
as
begin
	Update account set pass = @pass where account = @account
end 
go

create proc UpdatePassSendMail 
@pass varchar(200) , @email varchar(50)
as
begin
	Update account set pass = @pass where email = @email 
end
go

 --Admin


 create proc SelAccountAdmin
 @account  nvarchar(50)
 as
begin
	select account from account where account = @account
end 
go

 create proc SelPassAdmin
  @account  nvarchar(50)
 as
begin
	select pass from account where account = @account
end 
go

 create proc SelClassifyAdmin
  @account  nvarchar(50)
 as
begin
	select classify from account where account = @account
end 
go


create proc Selinfo
as
begin
		select * from account
end
go

create proc AddAcc
@fullname nvarchar(50),@gender varchar(6),@addr nvarchar(200),@dob date ,@phonenumber varchar(15) ,@email varchar(50),@account nvarchar(50),@classify char(1)
as
begin
	insert into account(fullname,gender,addr,dob,phonenumber,email,account,classify) values (@fullname,@gender,@addr,@dob,@phonenumber,@email,@account,@classify)
end 
go

create proc DelAcc
@id_acc int
as
begin
	delete from account where id_acc = @id_acc
end
go

create proc UpdateAcc
@fullname nvarchar(50),@gender varchar(6),@addr nvarchar(200),@dob date,@phonenumber varchar(15),@email varchar(50) , @id_acc int
as
begin 
		
		update account set fullname = @fullname,gender = @gender,addr = @addr ,dob = @dob ,phonenumber = @phonenumber,email = @email where id_acc = @id_acc

end
go

create proc SelInfoRoomChat
as
begin
	select roomChat.id_room, roomChat.name_room,roomChat.status_room ,roomMember.id_acc from roomChat inner join roomMember on roomChat.id_room = roomChat.id_room;
end
go

--/////////son
create proc SelImage
@account nvarchar(50)
as
begin
	select img from account where account =@account
end
go

create proc SelStatusAcc
@account  nvarchar(50)
as
begin
	select status_acc from account where account = @account
end
go



--////cuong
create proc DelAccount
@account NVARCHAR(50)
as
begin
	update  account set status_acc = 0 where account = @account
end
go

create proc getListInfoAccount
@account nvarchar(50)
as
begin
	select fullname , gender, addr, phonenumber , dob , email from account where account =@account
end
go



--/////////vinh
create proc selRequestFriend
@account varchar(20)
AS 
begin 
    select account_one from FriendChat where  account_two = @account and status_friend_two = '0'
end 
go 

create proc selFriend
@account varchar(20)
AS 
begin 
    select account_two from FriendChat where  account_one = @account and status_friend_one = '1' and status_friend_two = '1'
end 
go 


create proc selaccounttwo
 @id_acc int, @account varchar(20)
AS 
begin 
    select  account_two from FriendChat where id_acc = @id_acc and account_one = @account
end 
go 


create proc insertfriend
  @id_acc int, @account_one varchar(20), @account_two varchar(20), @status_friend_one char(1), @status_friend_two char(1)
AS 
begin 
    insert into FriendChat(id_acc, account_one, account_two, status_friend_one, status_friend_two) values(@id_acc, @account_one, @account_two, @status_friend_one, @status_friend_two)
end 
go

    create proc selStatusFriend
    @id_acc int, @account_one varchar(20), @account_two varchar(20)
    as 
    begin 
        select status_friend_one, status_friend_two from FriendChat where id_acc = @id_acc and account_one = @account_one and account_two = @account_two
    end 
    go


create proc  acceptFriend
   @id_acc int, @account_one varchar(20), @account_two varchar(20)
AS 
begin 
    update FriendChat set status_friend_one = '1', status_friend_two = '1' where id_acc = @id_acc and account_one = @account_one and account_two = @account_two
end 
go 

create proc  refusefriend
    @id_acc int, @account_one varchar(20), @account_two varchar(20)
AS 
begin 
    delete FriendChat where id_acc = @id_acc and account_one = @account_one and account_two = @account_two
end 
go 




create proc InsertMess
@id_acc int, 
    @mess NVARCHAR(1000),
    @time_send DATETIME,
    @account_one VARchar(50),
    @account_two VARCHAR(50),
    @status_mess char(1)

   
as 
begin 
    insert into privateMessage(id_acc, mess, time_send, account_one, account_two, status_mess) VALUES(@id_acc , @mess ,@time_send , @account_one, @account_two ,
    @status_mess )

end 
go 



    create proc selAcc
    @account varchar(20)
    as
    begin
        select id_acc, account,pass,classify,img from account where account = @account
    end
    go



create proc insertroom
@nameroom varchar(20), @portroom varchar(5)
as 
begin 
   insert into roomChat(name_room,status_room,portroom) VALUES(@nameroom,'1',@portroom)
end 
go 

    create proc selidroom
    @nameroom varchar(20)
    as
    begin
        select id_room,name_room,status_room,portroom from roomChat where name_room = @nameroom
    end
    go

        create proc selnameRoom
   
    as
    begin
        select id_room,name_room,status_room,portroom from roomChat 
    end
    go

    create proc insertmemberroom    
    @id_room int, @id_acc int, @mess NVARCHAR
    as 
    begin 
    insert into roomMember(id_room,id_acc,mess) VALUES(@id_room, @id_acc, @mess)
    end 
    go 

    create proc selPortRoom
    @name_room NVARCHAR(20)
    as 
    begin 
        select portroom from roomChat where name_room = @name_room
        end 
        go 

         create proc selnamrroom
    @name_room NVARCHAR(20)
    as 
    begin 
        select name_room from roomChat where name_room = @name_room
        end 
        go 

           create proc selAllPortroom
    
    as 
    begin 
        select portroom from roomChat 
        end 
        go 
--///////nam
create PROCEDURE SearchCustomers
   @account varchar(50)
AS
BEGIN
      SELECT id_acc, account, img
      FROM account
      WHERE account   LIKE  '%' + @account + '%'
END
 
GO

--- new 

    create proc selport
    @account_one varchar(20),  @account_two varchar(20)
    as
    begin
        select portchat from chatport where (account_one = @account_one or account_one = @account_two) and (account_two = @account_one or account_two = @account_two)
    end
    go

    create proc selAllport
   
    as
    begin
        select portchat from chatport
    end
    go

    create proc insertport
    @account_one varchar(20), @account_two varchar(20), @status_join_one char(1),  @status_join_two char(1), @portchat varchar(5)
    as 
    begin 
   insert into chatport(account_one,account_two,status_join_one,status_join_two,portchat) VALUES(@account_one, @account_two, @status_join_one, @status_join_two, @portchat)
    end 
    go 

        create proc selMessage
    @id_acc int,  @account_one varchar(20), @account_two varchar(20)
    as
    begin
        select top 1 mess from privateMessage where id_acc = @id_acc and account_one = @account_one and account_two = @account_two ORDER BY id_mess DESC
    end
    go

