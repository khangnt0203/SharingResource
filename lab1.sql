USE [master]
GO

CREATE DATABASE [SharingResources]
 
USE [SharingResources]
GO
/****** Object:  Table [dbo].[History]    Script Date: 26/08/2021 7:01:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[History](
	[historyID] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[assignmentDate] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[historyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 26/08/2021 7:01:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [varchar](150) NOT NULL,
	[CategoryDescription] [varchar](max) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRent]    Script Date: 26/08/2021 7:01:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRent](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ResourceId] [int] NOT NULL,
	[UserId] [int] NOT NULL,
	[NumberOfRentalDay] [int] NOT NULL,
	[RentDate] [date] NOT NULL,
	[Status] [nchar](25) NOT NULL,
 CONSTRAINT [PK_Rent] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblResource]    Script Date: 26/08/2021 7:01:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblResource](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](150) NOT NULL,
	[Color] [varchar](150) NOT NULL,
	[Quantity] [int] NOT NULL,
	[UsingDate] [int] NOT NULL,
	[Description] [varchar](250) NULL,
	[CategoryId] [int] NOT NULL,
 CONSTRAINT [PK_Resource] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 26/08/2021 7:01:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[roleID] [nchar](10) NOT NULL,
	[roleName] [nchar](10) NULL,
 CONSTRAINT [PK_tblRole] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 26/08/2021 7:01:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [nvarchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Name] [nvarchar](80) NOT NULL,
	[Phone] [nchar](10) NOT NULL,
	[Address] [nvarchar](150) NOT NULL,
	[CreateDate] [date] NOT NULL,
	[Status] [nchar](10) NOT NULL,
	[RoleID] [nchar](10) NULL,
 CONSTRAINT [PK_User1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[History] ON 

INSERT [dbo].[History] ([historyID], [username], [assignmentDate]) VALUES (1, N'zoro', N'2-7-2021')
INSERT [dbo].[History] ([historyID], [username], [assignmentDate]) VALUES (2, N'luffy', N'2-7-2021')
SET IDENTITY_INSERT [dbo].[History] OFF
GO
SET IDENTITY_INSERT [dbo].[tblCategory] ON 

INSERT [dbo].[tblCategory] ([Id], [CategoryName], [CategoryDescription]) VALUES (1, N'Office', N'everything in office')
INSERT [dbo].[tblCategory] ([Id], [CategoryName], [CategoryDescription]) VALUES (2, N'Entertainment', N'To watch video or sing')
INSERT [dbo].[tblCategory] ([Id], [CategoryName], [CategoryDescription]) VALUES (3, N'Paper documents', N'Document about some field in your company')
SET IDENTITY_INSERT [dbo].[tblCategory] OFF
GO
SET IDENTITY_INSERT [dbo].[tblRent] ON 

INSERT [dbo].[tblRent] ([Id], [ResourceId], [UserId], [NumberOfRentalDay], [RentDate], [Status]) VALUES (11, 11, 5, 6, CAST(N'2021-08-16' AS Date), N'accepted                 ')
INSERT [dbo].[tblRent] ([Id], [ResourceId], [UserId], [NumberOfRentalDay], [RentDate], [Status]) VALUES (13, 10, 45, 10, CAST(N'2021-08-17' AS Date), N'accepted                 ')
INSERT [dbo].[tblRent] ([Id], [ResourceId], [UserId], [NumberOfRentalDay], [RentDate], [Status]) VALUES (14, 11, 45, 3, CAST(N'2021-08-17' AS Date), N'rejected                 ')
INSERT [dbo].[tblRent] ([Id], [ResourceId], [UserId], [NumberOfRentalDay], [RentDate], [Status]) VALUES (16, 10, 47, 4, CAST(N'2021-08-25' AS Date), N'new                      ')
INSERT [dbo].[tblRent] ([Id], [ResourceId], [UserId], [NumberOfRentalDay], [RentDate], [Status]) VALUES (17, 18, 47, 7, CAST(N'2021-08-25' AS Date), N'new                      ')
INSERT [dbo].[tblRent] ([Id], [ResourceId], [UserId], [NumberOfRentalDay], [RentDate], [Status]) VALUES (19, 10, 45, 5, CAST(N'2021-08-25' AS Date), N'new                      ')
INSERT [dbo].[tblRent] ([Id], [ResourceId], [UserId], [NumberOfRentalDay], [RentDate], [Status]) VALUES (22, 10, 51, 1, CAST(N'2021-08-25' AS Date), N'new                      ')
SET IDENTITY_INSERT [dbo].[tblRent] OFF
GO
SET IDENTITY_INSERT [dbo].[tblResource] ON 

INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (1, N'Table', N'yellow', 12, 21, N'Not inlude chair', 1)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (2, N'Chair', N'grow', 10, 10, N'Not include chair', 1)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (4, N'Shell', N'green', 25, 12, N'Not include', 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (6, N'Microphone', N'grey', 30, 22, N'Not include audio', 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (7, N'Laptop', N'black', 25, 20, NULL, 1)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (8, N'Photocopy Machine', N'white', 5, 5, N'Not include paper', 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (9, N'Screen', N'grey', 5, 10, NULL, 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (10, N'Audio', N'black', 3, 5, NULL, 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (11, N'Backdrop', N'blue', 10, 20, NULL, 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (12, N'Light', N'pink', 4, 6, NULL, 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (13, N'LED light', N'green', 10, 5, NULL, 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (14, N'Scan', N'black', 5, 10, NULL, 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (15, N'Camera', N'grey', 9, 11, NULL, 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (16, N'Record', N'blue', 15, 7, NULL, 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (17, N'Projector', N'white', 5, 3, NULL, 1)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (18, N'Big Fan', N'brown', 7, 8, NULL, 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (19, N'Spotlight', N'black', 4, 2, NULL, 2)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (20, N'Headphone', N'orange', 14, 7, NULL, 1)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (21, N'Paper', N'white', 100, 7, NULL, 1)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (22, N'Motor Bike', N'brown', 5, 2, NULL, 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (23, N'Documentary', N'purple', 6, 1, NULL, 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (24, N'Coach', N'brown', 3, 2, NULL, 1)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (27, N'Decorator', N'pink', 7, 2, NULL, 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (28, N'Zip', N'orange', 24, 14, NULL, 3)
INSERT [dbo].[tblResource] ([Id], [Name], [Color], [Quantity], [UsingDate], [Description], [CategoryId]) VALUES (29, N'Helmet', N'purple', 14, 4, NULL, 3)
SET IDENTITY_INSERT [dbo].[tblResource] OFF
GO
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'1         ', N'manager   ')
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'2         ', N'employee  ')
GO
SET IDENTITY_INSERT [dbo].[tblUser] ON 

INSERT [dbo].[tblUser] ([Id], [UserID], [Password], [Name], [Phone], [Address], [CreateDate], [Status], [RoleID]) VALUES (1, N'manager                  ', N'123', N'Paul', N'0356266031', N'TP.HCM', CAST(N'2021-05-11' AS Date), N'active    ', N'1         ')
INSERT [dbo].[tblUser] ([Id], [UserID], [Password], [Name], [Phone], [Address], [CreateDate], [Status], [RoleID]) VALUES (5, N'employee                 ', N'123', N'King', N'0356266031', N'TP.Thủ Đức', CAST(N'2021-05-11' AS Date), N'enable    ', N'2         ')
INSERT [dbo].[tblUser] ([Id], [UserID], [Password], [Name], [Phone], [Address], [CreateDate], [Status], [RoleID]) VALUES (23, N'abc@gmail.com', N'123', N'Jeffrey', N'1234567890', N'Tp.HCM', CAST(N'2021-06-23' AS Date), N'new       ', N'2         ')
INSERT [dbo].[tblUser] ([Id], [UserID], [Password], [Name], [Phone], [Address], [CreateDate], [Status], [RoleID]) VALUES (26, N'demo@gmail.com', N'123', N'Demo', N'0123345678', N'Thu Duc', CAST(N'2021-08-09' AS Date), N'new       ', N'2         ')
INSERT [dbo].[tblUser] ([Id], [UserID], [Password], [Name], [Phone], [Address], [CreateDate], [Status], [RoleID]) VALUES (45, N'levutruong87@gmail.com', N'123', N'User', N'0123456789', N'Quan 9', CAST(N'2021-08-17' AS Date), N'active    ', N'2         ')
INSERT [dbo].[tblUser] ([Id], [UserID], [Password], [Name], [Phone], [Address], [CreateDate], [Status], [RoleID]) VALUES (47, N'khang.h15.cla@gmail.com', N'khang.h15.cla@gmail.comkhang.h15.cla!@#', N'khang.h15.cla', N'0123456789', N'Nope', CAST(N'2021-08-25' AS Date), N'Active    ', N'2         ')
INSERT [dbo].[tblUser] ([Id], [UserID], [Password], [Name], [Phone], [Address], [CreateDate], [Status], [RoleID]) VALUES (51, N'lygiahan206@gmail.com', N'123', N'Han', N'1234567892', N'Quan Cam', CAST(N'2021-08-25' AS Date), N'active    ', N'2         ')
SET IDENTITY_INSERT [dbo].[tblUser] OFF
GO
ALTER TABLE [dbo].[tblRent] ADD  CONSTRAINT [DF_Rent_RentDate]  DEFAULT (getdate()) FOR [RentDate]
GO
ALTER TABLE [dbo].[tblUser] ADD  CONSTRAINT [DF_User_CreateDate]  DEFAULT (getdate()) FOR [CreateDate]
GO
ALTER TABLE [dbo].[tblRent]  WITH CHECK ADD  CONSTRAINT [FK_Rent_Resource1] FOREIGN KEY([ResourceId])
REFERENCES [dbo].[tblResource] ([Id])
GO
ALTER TABLE [dbo].[tblRent] CHECK CONSTRAINT [FK_Rent_Resource1]
GO
ALTER TABLE [dbo].[tblRent]  WITH CHECK ADD  CONSTRAINT [FK_Rent_User] FOREIGN KEY([UserId])
REFERENCES [dbo].[tblUser] ([Id])
GO
ALTER TABLE [dbo].[tblRent] CHECK CONSTRAINT [FK_Rent_User]
GO
ALTER TABLE [dbo].[tblResource]  WITH CHECK ADD  CONSTRAINT [FK_Resource_Category] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[tblCategory] ([Id])
GO
ALTER TABLE [dbo].[tblResource] CHECK CONSTRAINT [FK_Resource_Category]
GO
ALTER TABLE [dbo].[tblUser]  WITH CHECK ADD FOREIGN KEY([RoleID])
REFERENCES [dbo].[tblRole] ([roleID])
GO
USE [master]
GO
ALTER DATABASE [SharingResources] SET  READ_WRITE 
GO
