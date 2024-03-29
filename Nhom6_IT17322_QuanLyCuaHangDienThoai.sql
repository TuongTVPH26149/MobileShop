CREATE DATABASE Nhom6_IT17322_QuanLyCuaHangDienThoai
GO
USE [Nhom6_IT17322_QuanLyCuaHangDienThoai]
GO
/****** Object:  Table [dbo].[BaoHanh]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaoHanh](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[TrangThai] [int] NULL,
	[IdImei] [uniqueidentifier] NULL,
	[NgayBaoHanh] [date] NOT NULL,
	[NgayHoanThanh] [date] NULL,
	[NgayKhachLay] [date] NULL,
	[LyDo] [nvarchar](100) NULL,
	[MoTa] [nvarchar](100) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSP]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSP](
	[Id] [uniqueidentifier] NOT NULL,
	[IdRom] [uniqueidentifier] NULL,
	[IdRam] [uniqueidentifier] NULL,
	[IdMauSac] [uniqueidentifier] NULL,
	[IdCPU] [uniqueidentifier] NULL,
	[IdManHinh] [uniqueidentifier] NULL,
	[IdPin] [uniqueidentifier] NULL,
	[LoaiHang] [int] NULL,
	[Gia] [decimal](20, 0) NULL,
	[SoLuong] [int] NULL,
	[Mota] [varchar](50) NULL,
	[IdKhuyenMai] [uniqueidentifier] NULL,
	[IdSP] [uniqueidentifier] NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CPU]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CPU](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NOT NULL,
	[Ten] [nvarchar](30) NOT NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[Id] [uniqueidentifier] NOT NULL,
	[IdKH] [uniqueidentifier] NULL,
	[IdTK] [uniqueidentifier] NULL,
	[Ma] [varchar](20) NOT NULL,
	[MaGiaoDich] [varchar](20) NULL,
	[NgayTao] [date] NULL,
	[NgayThanhToan] [date] NULL,
	[NgayNhanHang] [date] NULL,
	[NgayShip] [date] NULL,
	[NgayNhanMongMuon] [datetime] NULL,
	[TienShip] [decimal](20, 0) NULL,
	[TienThua] [decimal](20, 0) NULL,
	[TienMat] [decimal](20, 0) NULL,
	[ChuyenKhoan] [decimal](20, 0) NULL,
	[TenKH] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[TongTien] [decimal](20, 0) NULL,
	[TrangThai] [int] NULL,
	[SoLanShip] [int] NULL,
	[SdtNguoiShip] [varchar](15) NULL,
	[TenNguoiShip] [nvarchar](50) NULL,
	[SdtNguoiNhan] [varchar](15) NULL,
	[LoaiThanhToan] [int] NULL,
	[GiamGia] [decimal](20, 0) NULL,
	[LyDo] [nvarchar](100) NULL,
	[lastModifiedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[Id] [uniqueidentifier] NOT NULL,
	[IdHoaDon] [uniqueidentifier] NULL,
	[IdChiTietSP] [uniqueidentifier] NULL,
	[TenSP] [nvarchar](100) NOT NULL,
	[DonGia] [decimal](20, 0) NULL,
	[Thanhtien] [decimal](20, 0) NULL,
	[SoLuong] [int] NOT NULL,
	[TrangThai] [int] NULL,
	[KhuyenMai] [decimal](20, 0) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Imei]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Imei](
	[Id] [uniqueidentifier] NOT NULL,
	[IdChiTietSP] [uniqueidentifier] NULL,
	[Ma] [char](15) NOT NULL,
	[TrangThai] [int] NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImeiBan]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImeiBan](
	[Id] [uniqueidentifier] NOT NULL,
	[IdHoaDonChiTiet] [uniqueidentifier] NULL,
	[Ma] [char](15) NOT NULL,
	[LyDo] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[GioiTinh] [int] NULL,
	[Sdt] [varchar](15) NOT NULL,
	[DiaChi] [nvarchar](100) NULL,
	[NgaySinh] [date] NULL,
	[CapDo] [int] NULL,
	[NgayTutHang] [date] NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NOT NULL,
	[Ten] [nvarchar](30) NOT NULL,
	[NgayBD] [datetime] NOT NULL,
	[NgayKT] [datetime] NOT NULL,
	[GiaTri] [int] NULL,
	[TrangThai] [int] NULL,
	[LoaiKM] [int] NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ManHinh]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ManHinh](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pin]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pin](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ram]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ram](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rom]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rom](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
	[Deleted] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 05-Apr-23 14:59:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[HoTen] [nvarchar](50) NULL,
	[GioiTinh] [int] NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Email] [varchar](100) NOT NULL,
	[Sdt] [varchar](15) NULL,
	[MatKhau] [varchar](100) NOT NULL,
	[ChucVu] [int] NULL,
	[HinhAnh] [varchar](50) NULL,
	[TrangThai] [int] NULL,
	[CreatedDate] [date] NULL,
	[lastModifiedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'c25c5e59-a58a-b545-85c4-6f6c368f707b', N'830a2d87-02fb-8842-b0df-a58711e0116c', N'd7cca0b3-ddd5-254e-9520-3525023f75d7', N'ad824564-6c61-3d4c-80cc-f1376eb7e62b', N'addda214-ea11-6d4d-956c-f2e86b44346b', N'b16a908d-2102-a249-b72e-b1e459d31586', 0, CAST(6000000 AS Decimal(20, 0)), 21, NULL, N'a1147421-93f3-e84a-8190-dd84ba3ee35e', N'884bf2ed-9e0b-f948-a1b9-c6216de927fd', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'09f09a12-28ac-db48-aca4-d391d8c77821', N'830a2d87-02fb-8842-b0df-a58711e0116c', N'9a51f8c1-060f-b843-ac3f-d47f2616a717', N'9cb9057b-b77b-2141-81e8-a0de43eedcdf', N'f76a36c0-724b-3e4c-9cb0-a386af68dc7c', N'b16a908d-2102-a249-b72e-b1e459d31586', 0, CAST(14000000 AS Decimal(20, 0)), 22, NULL, N'a1147421-93f3-e84a-8190-dd84ba3ee35e', N'0ffd41eb-2e4b-d84a-9d15-b331d8c5ae44', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'09f09a12-28ac-db48-aca4-d391d8c77821', N'830a2d87-02fb-8842-b0df-a58711e0116c', N'9a51f8c1-060f-b843-ac3f-d47f2616a717', N'a30eec54-534d-fe42-8471-879138bffd09', N'0612a19a-d9a6-fb4b-b03a-ce98c875778a', N'b16a908d-2102-a249-b72e-b1e459d31586', 0, CAST(24000000 AS Decimal(20, 0)), 21, NULL, N'a1147421-93f3-e84a-8190-dd84ba3ee35e', N'1a7d0f59-8b41-e44c-966d-cfa775911e92', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'0d6b2aff-c49c-624a-ab9c-ab18cd1a7902', N'2c743540-5dd3-0448-82d7-c994857e0bba', N'9a51f8c1-060f-b843-ac3f-d47f2616a717', N'0c1b85c3-3e69-fe4f-aa17-c75e1a4f6297', N'0612a19a-d9a6-fb4b-b03a-ce98c875778a', N'69f23364-149f-cc47-af67-c06e5f029622', 0, CAST(30000000 AS Decimal(20, 0)), 21, NULL, N'3208f88a-137a-b248-8171-75642a9a0be8', N'3e67b514-8d2c-af43-8896-78ff3f205c8c', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'f2fce050-6d26-0b45-9664-70287946c250', N'c67a0ddf-48c4-ba4f-8a87-59b5a6c5ff04', N'1a5c326a-0510-6f4b-a88a-5bab9354bee8', N'd7cca0b3-ddd5-254e-9520-3525023f75d7', N'f70a7e75-0a37-c041-8f31-35d23a7a5f5d', N'06fe5aa0-2433-054f-9c00-7da7713807b7', N'18f2f6f2-38ed-2749-87e4-58a34c9e983c', 0, CAST(10000000 AS Decimal(20, 0)), 19, NULL, N'3208f88a-137a-b248-8171-75642a9a0be8', N'a59a3c9f-af4d-c146-84a6-38ecaa48bdb7', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'09cee92e-ef53-ca41-955b-745136e63b81', N'c67a0ddf-48c4-ba4f-8a87-59b5a6c5ff04', N'1a5c326a-0510-6f4b-a88a-5bab9354bee8', N'd7cca0b3-ddd5-254e-9520-3525023f75d7', N'f70a7e75-0a37-c041-8f31-35d23a7a5f5d', N'06fe5aa0-2433-054f-9c00-7da7713807b7', N'b16a908d-2102-a249-b72e-b1e459d31586', 0, CAST(15000000 AS Decimal(20, 0)), 23, NULL, N'3208f88a-137a-b248-8171-75642a9a0be8', N'9d97a06f-7845-4845-ad4d-94961de8b643', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'71d6aca1-420c-6c44-aa4e-c80be126b7af', N'830a2d87-02fb-8842-b0df-a58711e0116c', N'9a51f8c1-060f-b843-ac3f-d47f2616a717', N'a30eec54-534d-fe42-8471-879138bffd09', N'0612a19a-d9a6-fb4b-b03a-ce98c875778a', N'69f23364-149f-cc47-af67-c06e5f029622', 0, CAST(5000000 AS Decimal(20, 0)), 22, NULL, N'387e3ede-a21e-5f4a-bc88-9e66278071eb', N'ccec3327-e968-9445-a14e-3dc2e85c221a', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'c67a0ddf-48c4-ba4f-8a87-59b5a6c5ff04', N'89b39aea-4b33-0244-9abf-f8fd735a0598', N'd7cca0b3-ddd5-254e-9520-3525023f75d7', N'f70a7e75-0a37-c041-8f31-35d23a7a5f5d', N'0612a19a-d9a6-fb4b-b03a-ce98c875778a', N'b16a908d-2102-a249-b72e-b1e459d31586', 0, CAST(20000000 AS Decimal(20, 0)), 22, NULL, N'387e3ede-a21e-5f4a-bc88-9e66278071eb', N'573ec3d3-82fa-8242-863d-a70b238e1bf9', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ChiTietSP] ([Id], [IdRom], [IdRam], [IdMauSac], [IdCPU], [IdManHinh], [IdPin], [LoaiHang], [Gia], [SoLuong], [Mota], [IdKhuyenMai], [IdSP], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'c25c5e59-a58a-b545-85c4-6f6c368f707b', N'2c743540-5dd3-0448-82d7-c994857e0bba', N'd7cca0b3-ddd5-254e-9520-3525023f75d7', N'f516d8ae-e340-3141-a728-4d48c979467d', N'f76a36c0-724b-3e4c-9cb0-a386af68dc7c', N'69f23364-149f-cc47-af67-c06e5f029622', 0, CAST(20000000 AS Decimal(20, 0)), 26, NULL, NULL, N'aeaef4ae-0ec4-9042-a381-87b00183c819', CAST(N'2023-04-05' AS Date), NULL, 0)
GO
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'f70a7e75-0a37-c041-8f31-35d23a7a5f5d', N'CPU4', N'Apple A12 Bionic', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'f516d8ae-e340-3141-a728-4d48c979467d', N'CPU5', N'Qualcomm Snapdragon 855', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'a30eec54-534d-fe42-8471-879138bffd09', N'CPU3', N'Apple A13 Bionic', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'9cb9057b-b77b-2141-81e8-a0de43eedcdf', N'CPU1', N'Qualcomm Snapdragon 888', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'23370e8b-3eb6-594a-9148-bbcd70d99766', N'CPU2', N'Samsung Exynos 2100', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'0c1b85c3-3e69-fe4f-aa17-c75e1a4f6297', N'CPU6', N'Apple A11 Bionic', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'ad824564-6c61-3d4c-80cc-f1376eb7e62b', N'CPU7', N'Qualcomm Snapdragon 845', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[CPU] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'3272afce-7abb-954f-8f09-f7de49ecd036', N'CPU8', N'MediaTek Dimensity 1200', CAST(N'2023-04-05' AS Date), NULL, 0)
GO
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'dd25e32c-acc5-8744-891c-133906c5c6cd', N'f6422180-7fe3-974f-846b-0c01a0375eb1', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143132526', NULL, CAST(N'2020-04-05' AS Date), CAST(N'2020-04-05' AS Date), CAST(N'2020-04-05' AS Date), CAST(N'2023-04-05' AS Date), NULL, CAST(0 AS Decimal(20, 0)), CAST(58888888 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(8888888 AS Decimal(20, 0)), N'Nguyễn Văn Tý', N'Hà Nội', CAST(6000000 AS Decimal(20, 0)), 4, 1, N'0927366753', N'Nguyễn Văn Nhật', N'0987654329', 1, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'a9d7b074-a858-7340-8dce-14fb9891cf2b', N'4f18cb1e-60a5-4abd-83a5-f4448f6164fe', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405142557542', NULL, CAST(N'2022-04-05' AS Date), CAST(N'2022-04-05' AS Date), CAST(N'2022-04-05' AS Date), NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(6000000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Khách lẻ', N'Tại cửa hàng', CAST(6000000 AS Decimal(20, 0)), 3, 0, NULL, NULL, N'0', 0, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2022-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'7b3b0b29-da99-8f4b-89ba-3d3738dbe536', N'4f18cb1e-60a5-4abd-83a5-f4448f6164fe', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143018506', NULL, CAST(N'2019-04-05' AS Date), CAST(N'2019-04-05' AS Date), CAST(N'2019-04-05' AS Date), NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(999975999999 AS Decimal(20, 0)), CAST(999999999999 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Khách lẻ', N'Tại cửa hàng', CAST(24000000 AS Decimal(20, 0)), 3, 0, NULL, NULL, N'0', 0, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'1daa3613-cca6-ac47-abb6-43ee217c7b24', N'4f18cb1e-60a5-4abd-83a5-f4448f6164fe', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405144450563', NULL, CAST(N'2023-04-05' AS Date), NULL, NULL, NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Khách lẻ', N'Tại cửa hàng', CAST(0 AS Decimal(20, 0)), 0, 0, NULL, NULL, N'0', 0, CAST(0 AS Decimal(20, 0)), NULL, NULL)
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'335f42a2-ed25-4e42-a253-53e8610c737c', N'10e97662-a3da-7244-a0e7-72355e0abf84', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143624968', NULL, CAST(N'2023-04-05' AS Date), CAST(N'2023-01-05' AS Date), CAST(N'2023-01-05' AS Date), CAST(N'2023-04-05' AS Date), CAST(N'2022-03-31T02:30:00.000' AS DateTime), CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(99999999 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Nguyễn Văn Tú', N'Hà Nội', CAST(15000000 AS Decimal(20, 0)), 4, 1, N'0927366934', N'Nguyễn Thị Phương Oanh', N'0987654325', 0, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'bef80baf-e76f-834b-9e47-7510a9316696', N'17fa0f2e-daf2-964e-b4ff-f7b618722f50', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143051729', NULL, CAST(N'2023-02-05' AS Date), CAST(N'2023-02-05' AS Date), CAST(N'2018-04-05' AS Date), CAST(N'2018-04-05' AS Date), NULL, CAST(50000 AS Decimal(20, 0)), CAST(58888888 AS Decimal(20, 0)), CAST(50000000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Nguyễn Văn Tuyền', N'Hà Nội', CAST(24050000 AS Decimal(20, 0)), 4, 1, N'0927366753', N'Nguyễn Văn Nhật', N'0987954329', 0, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'e60691fd-1d83-074c-a79c-7fa404ae40ff', N'3c953201-6a83-f045-aa56-d26405e65308', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143032632', NULL, CAST(N'2023-03-05' AS Date), CAST(N'2023-03-05' AS Date), CAST(N'2023-03-05' AS Date), NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(58888888 AS Decimal(20, 0)), CAST(88888888 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Nguyễn Thi Tuyết', N'Tại cửa hàng', CAST(30000000 AS Decimal(20, 0)), 3, 0, NULL, NULL, N'0987654323', 0, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'871f2463-d7c3-f841-a6cb-86d0db7f8414', N'3c953201-6a83-f045-aa56-d26405e65308', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143536068', NULL, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-01' AS Date), CAST(N'2023-04-01' AS Date), NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(71199999 AS Decimal(20, 0)), CAST(99999999 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Nguyễn Thi Tuyết', N'Tại cửa hàng', CAST(28800000 AS Decimal(20, 0)), 3, 0, NULL, NULL, N'0987654323', 0, CAST(1200000 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'35bd3bd2-ec60-a443-9f75-bc5aa8a6978f', N'4f18cb1e-60a5-4abd-83a5-f4448f6164fe', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405144045250', NULL, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-04' AS Date), CAST(N'2023-04-04' AS Date), NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(1111110 AS Decimal(20, 0)), CAST(5555555 AS Decimal(20, 0)), CAST(5555555 AS Decimal(20, 0)), N'Khách lẻ', N'Tại cửa hàng', CAST(10000000 AS Decimal(20, 0)), 3, 0, NULL, NULL, N'0', 2, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'e499960a-af56-2a44-bc1c-cafe0d56a06f', N'f6422180-7fe3-974f-846b-0c01a0375eb1', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143554328', NULL, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-02' AS Date), CAST(N'2023-04-02' AS Date), NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(73888888 AS Decimal(20, 0)), CAST(88888888 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), N'Nguyễn Văn Tý', N'Tại cửa hàng', CAST(15000000 AS Decimal(20, 0)), 3, 0, NULL, NULL, N'0987654329', 0, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdTK], [Ma], [MaGiaoDich], [NgayTao], [NgayThanhToan], [NgayNhanHang], [NgayShip], [NgayNhanMongMuon], [TienShip], [TienThua], [TienMat], [ChuyenKhoan], [TenKH], [DiaChi], [TongTien], [TrangThai], [SoLanShip], [SdtNguoiShip], [TenNguoiShip], [SdtNguoiNhan], [LoaiThanhToan], [GiamGia], [LyDo], [lastModifiedDate]) VALUES (N'7a26900a-dddd-ca44-b4d1-e161ee753e61', N'4f18cb1e-60a5-4abd-83a5-f4448f6164fe', N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'HD20230405143709285', NULL, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-03' AS Date), CAST(N'2023-04-03' AS Date), NULL, NULL, CAST(0 AS Decimal(20, 0)), CAST(5999998 AS Decimal(20, 0)), CAST(9999999 AS Decimal(20, 0)), CAST(999999 AS Decimal(20, 0)), N'Khách lẻ', N'Tại cửa hàng', CAST(5000000 AS Decimal(20, 0)), 3, 0, NULL, NULL, N'0', 2, CAST(0 AS Decimal(20, 0)), NULL, CAST(N'2023-04-05' AS Date))
GO
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'9f0f2380-39db-3e44-b71b-19ee7d21b897', N'7a26900a-dddd-ca44-b4d1-e161ee753e61', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'Oppo A3 Tím 12GB/64GB Mới', CAST(5000000 AS Decimal(20, 0)), CAST(5000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'b56646cb-82a1-784c-b486-203982176d0f', N'dd25e32c-acc5-8744-891c-133906c5c6cd', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'Vinmart Live 4 Trắng 12GB/32GB Mới', CAST(6000000 AS Decimal(20, 0)), CAST(6000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'24889e2e-0be5-db45-ab76-61bf93530059', N'e499960a-af56-2a44-bc1c-cafe0d56a06f', N'09cee92e-ef53-ca41-955b-745136e63b81', N'Iphone 6 Plus Trắng 10GB/16GB Mới', CAST(15000000 AS Decimal(20, 0)), CAST(15000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'b2848e5a-344c-154e-919b-74497c2e8c04', N'871f2463-d7c3-f841-a6cb-86d0db7f8414', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'Iphone 12 Tím 2GB/256GB Mới', CAST(30000000 AS Decimal(20, 0)), CAST(30000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'9dc2006e-63a8-2b40-87de-7a07f47cebcf', N'7b3b0b29-da99-8f4b-89ba-3d3738dbe536', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'SamSung A7 Tím 12GB/128GB Mới', CAST(24000000 AS Decimal(20, 0)), CAST(24000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'9c32d31d-bf2f-964e-b426-8d23dfd08ee3', N'e60691fd-1d83-074c-a79c-7fa404ae40ff', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'Iphone 12 Tím 2GB/256GB Mới', CAST(30000000 AS Decimal(20, 0)), CAST(30000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'ba87be8d-e249-df4d-8f56-a77d063678a1', N'bef80baf-e76f-834b-9e47-7510a9316696', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'SamSung A7 Tím 12GB/128GB Mới', CAST(24000000 AS Decimal(20, 0)), CAST(24000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'3914cff4-0c11-4c49-9568-ba3699730019', N'35bd3bd2-ec60-a443-9f75-bc5aa8a6978f', N'f2fce050-6d26-0b45-9664-70287946c250', N'Iphone 6 Trắng 10GB/16GB Mới', CAST(10000000 AS Decimal(20, 0)), CAST(10000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'c66f494c-7990-d343-b9ec-c1d36aaba112', N'a9d7b074-a858-7340-8dce-14fb9891cf2b', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'Vinmart Live 4 Trắng 12GB/32GB Mới', CAST(6000000 AS Decimal(20, 0)), CAST(6000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[HoaDonChiTiet] ([Id], [IdHoaDon], [IdChiTietSP], [TenSP], [DonGia], [Thanhtien], [SoLuong], [TrangThai], [KhuyenMai], [CreatedDate], [lastModifiedDate]) VALUES (N'7236a43d-835f-9148-a282-ce7222eb1055', N'335f42a2-ed25-4e42-a253-53e8610c737c', N'09cee92e-ef53-ca41-955b-745136e63b81', N'Iphone 6 Plus Trắng 10GB/16GB Mới', CAST(15000000 AS Decimal(20, 0)), CAST(15000000 AS Decimal(20, 0)), 1, 1, CAST(0 AS Decimal(20, 0)), CAST(N'2023-04-05' AS Date), NULL)
GO
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'2088794d-9efc-8949-9b1a-01a849be5b51', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'534399752409447', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1fd21983-1fcd-7a42-b465-02ab80558936', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'631472503394581', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'08b48d26-be5b-3342-a399-06fda77ba201', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'191031758435933', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'5fa0a84e-3aea-5045-baa3-077f5cc349f9', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'629477667821459', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1ba4acfd-8631-b145-9106-07a0e04526ce', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'645555999290362', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'3017e25d-c845-ef43-8e4f-09d47e88fafe', N'f2fce050-6d26-0b45-9664-70287946c250', N'94637722558337 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'182a9417-13a9-d24f-9083-0addc4b1c5f0', N'f2fce050-6d26-0b45-9664-70287946c250', N'158696918076323', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'f6340a27-a147-ff46-9917-0bb003fe7499', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'217332499116768', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'cccf34b5-0a61-4442-9872-0e9183262c3e', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'625561986616016', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'21933f73-1d49-984b-8d34-10cd6c3656c3', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'913978265930806', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8578944f-af76-234a-bbc0-113e1a5d5e09', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'231492060209118', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'c913cca3-e91d-344c-ad0d-12f58731f52e', N'09cee92e-ef53-ca41-955b-745136e63b81', N'669270995978494', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'828d9786-b128-5242-b83f-1325e79c4c7f', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'215743241414218', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ca66c030-b30b-474b-9bca-132ea221320c', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'206578259576754', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'74151cc9-c5d3-204a-b4cc-139711cd10cc', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'748264336765455', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'9cb12127-8f0b-ba41-ab2c-13bc589f27b5', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'448090658654752', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'6de293ea-bf96-d841-9b92-18b0908fc518', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'344580945306404', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd3d2884e-7e33-4207-82a9-19079881f355', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'654            ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd564976b-2a30-8147-943b-198fa2323553', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'516973474529986', 1, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ec14eb96-a32e-6d40-8d10-1d697bf2bd58', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'254538421144183', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'dcdb94c6-2f40-b84d-91f3-1fb9cfe6864a', N'09cee92e-ef53-ca41-955b-745136e63b81', N'69027055779001 ', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'04ff4567-91b5-cd4e-aaf7-1fed4ec5e04e', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'938415359239921', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'339ff572-4ed3-4941-a185-216e7fe3426c', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'134522054331184', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'979259ec-d2bd-3e4e-8258-233ef70b88b1', N'09cee92e-ef53-ca41-955b-745136e63b81', N'158470329964175', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'a537e592-18a9-c947-966f-2565bef97e9f', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'415665571874186', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'c0219233-2181-f74e-ab96-2c37eaf32147', N'09cee92e-ef53-ca41-955b-745136e63b81', N'358360648287592', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8e7087a9-6156-7b47-a480-2cd2e3056b8d', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'666515343468099', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'0c9786ee-1f16-694f-aebb-2d1e42146a9f', N'09cee92e-ef53-ca41-955b-745136e63b81', N'575124650273303', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'909c1f6e-576a-fe4b-a85c-2ed91b2c06ec', N'f2fce050-6d26-0b45-9664-70287946c250', N'210603907199451', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'51f0e1c1-2f13-0849-8b95-2f81724d0214', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'159378142258004', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'19fe60dc-e976-7843-beb8-2fb675c85e1a', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'238890162964267', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'80d93ea8-e5f4-2d40-896b-2fc26fd81b58', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'451172012705269', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'aa960d63-ed83-7041-8bef-31510b3d6c4e', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'678672289061052', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'38b156aa-0034-cc42-ba04-34b8c7802e6d', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'632337888937256', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'99649a41-03e4-604f-8785-35631d9d8a6c', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'348542007213569', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'cb70a082-cc3d-7546-ab41-371eca7170a0', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'173657634180182', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd3acc631-abea-3b47-b9a4-3811e5babaea', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'51404700601252 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8a6c764d-ef88-2841-8052-3895af8654cd', N'f2fce050-6d26-0b45-9664-70287946c250', N'91503452989357 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'94d5e03f-ed57-ec46-b8bc-3917877a20be', N'09cee92e-ef53-ca41-955b-745136e63b81', N'368235561147259', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7ac1f7e1-be86-3c42-9a2c-39179f875861', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'307913626508630', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'039a0972-faf3-eb41-9db1-3938b666f151', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'559166330995834', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'31c4018f-a27a-dd43-955d-3cae7c72546d', N'09cee92e-ef53-ca41-955b-745136e63b81', N'198367111574676', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'62e74c26-700f-2845-b2c4-3d527db5fc0e', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'218256851579540', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7795ef3d-e8ef-df43-83df-3e5da78d346f', N'09cee92e-ef53-ca41-955b-745136e63b81', N'383657626163361', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'31bf9a91-8523-5b40-9541-3f4c4071b96c', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'447310422782032', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'854b2412-52b0-6740-8eea-40305b776ca2', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'707355237763430', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'74df38b2-3d5b-f545-a84a-422f7086ed2a', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'462879271099215', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd8d49447-ff44-1246-b704-42b095bc1fd9', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'654585318588100', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'35386d0e-e4f9-d845-b7ab-43b0d2bcbf10', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'544026472026018', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'0339db18-0e82-5f44-8691-4460ee35e214', N'09cee92e-ef53-ca41-955b-745136e63b81', N'680856133792894', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'3b713f34-dbe4-a841-9341-4558cae77768', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'176200058084788', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'698d44db-3d84-c648-ae95-47082db34626', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'177585198483368', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'50d9a345-d3e9-5349-b50e-493b48d7871e', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'505302721010893', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ee2176c5-e9c6-ed41-a948-4cfd982086d6', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'247389508392797', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'924c5946-4b03-b347-a72b-4db04af35cb1', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'955468908719494', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ecc7acea-8d0d-e341-a3b6-4e128c3becd3', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'410325258796622', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e8bd8c53-5992-374b-992c-511454fbab1e', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'30660691599854 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'fce3220d-3ae3-4565-961c-511abf9c58a7', N'09cee92e-ef53-ca41-955b-745136e63b81', N'123            ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'0a3fd53a-a7a3-8543-a99f-52de0c685804', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'817244107526610', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1904fe9e-4134-2949-bd25-53305286ff11', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'702453361742424', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'471aa210-a7a9-514d-b8d9-5383135a7519', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'952806880218526', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'57a6e44b-c884-7349-8934-539296b0900a', N'09cee92e-ef53-ca41-955b-745136e63b81', N'745611775178112', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'178e6921-a943-b547-83e9-54a0900ee4d1', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'770214443236478', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7aaf7ada-0368-104c-b5ce-55198843d83e', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'95836080548615 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'a2fd1835-4309-dc46-ac4e-586ade729959', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'585104140259216', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'2be419cc-e5cd-0546-b270-590902d78466', N'f2fce050-6d26-0b45-9664-70287946c250', N'896314714828315', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'c6dfca12-8acd-694f-bbe8-5c3eb668f174', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'419504355752470', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'08459d61-ac0e-e943-83bf-5d32487ec8b3', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'470088023221296', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'48cba8ac-57eb-7542-84ab-5dc9aca78dab', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'489665448144651', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'3406ecf8-2b7c-234c-980a-60c4107406f7', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'842204852438915', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd6017fb7-e30d-684a-a708-630d51aa1aa5', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'39255481164510 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7ebb601e-fb22-6942-a469-635befad7860', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'275219498230173', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'a60715ad-f4c3-6544-bda4-645986944121', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'956075911545843', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'18d8dc38-00c3-5849-ac89-65674dd84b17', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'270609310828107', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'75a84286-a676-b245-92d1-65ee9afdd585', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'759919531382868', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'79821c26-922c-d041-a7dd-661e5394b1ca', N'f2fce050-6d26-0b45-9664-70287946c250', N'629523073302023', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'71bbb4de-56fe-be4c-aec4-670c6c0a08df', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'897863913019669', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'fa8131e6-a637-7549-8f03-6786a04344f8', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'577724830145801', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd01a6c3d-397a-b448-b883-68aaeafadc7d', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'258340152859794', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'3ccad026-660f-6b4e-b8c1-69b2727dfbaf', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'127174813799761', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'5b28ae4f-98e4-4d49-ba9e-6a433fbdedfc', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'917522304741087', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'886ad6a5-6784-f347-89a2-6ce64ddeb96e', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'677697943672601', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e0a04ecf-c088-0444-b8b0-6f6ad6c92201', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'835644899027046', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd2b20aac-df25-374d-9ae3-72c459eb47cf', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'38703379294350 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'5ac30ff1-f1a1-8b45-8f8a-755a5677d3a0', N'f2fce050-6d26-0b45-9664-70287946c250', N'605366743722905', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'691600e5-1712-2c4e-aaac-77f6e77de306', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'523062731195711', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'365efad0-3c9e-b04d-9b12-7a2953f87cc0', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'630543573863597', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'2b180836-5e4a-3941-8635-7b4961d0cae2', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'683135800125069', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'0980c431-65a2-874c-b117-7b7206ec3e4c', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'687115261310706', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'4a7f7950-09a3-9848-9ffe-7c9efa7d9c12', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'812424577046717', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'227e117f-8ac9-3941-b030-7d558178a488', N'09cee92e-ef53-ca41-955b-745136e63b81', N'320779878828554', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'350b9681-3023-334f-a647-7e04dfa0f115', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'713620597613193', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'553fb67b-d6e9-2541-9b71-7e9cf7ab6c69', N'f2fce050-6d26-0b45-9664-70287946c250', N'495450396969336', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1805a01c-dcdd-a746-8b50-7eb7d9293b02', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'60865807559944 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'9d98a1cd-5cbb-184e-8f67-8070a0a3d1bc', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'138751691771390', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'3cb741a1-5fd9-4f72-b6cb-80970b45c3ca', N'09cee92e-ef53-ca41-955b-745136e63b81', N'789            ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'300c5586-1a12-ad40-8523-80b3849eba78', N'f2fce050-6d26-0b45-9664-70287946c250', N'628050847898868', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'bac2006c-7d1b-7344-b754-80d50ea192cd', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'233836516943600', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'79eb5734-3b6b-7043-bfa9-812e5f7126dc', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'251052818122477', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'b97a534d-f854-d54f-a3da-81f411393a04', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'44877013605593 ', 1, CAST(N'2023-04-05' AS Date), NULL)
GO
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1269b1fd-f7ab-044b-9baf-8205c917f65f', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'557111399875844', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7bb74772-54d4-d841-a9a6-828cbe8047e0', N'09cee92e-ef53-ca41-955b-745136e63b81', N'384346158349303', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'42fc2114-4ef9-8b48-bd38-8375af112082', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'421530340012070', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8f2b1b4e-cf5b-664d-a6cd-8488a97ce01a', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'535361893800807', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ba2d6f74-9eaa-e841-8933-850ccf75f61c', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'514251471179234', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'26701037-a834-7948-8f83-8611ea0d2e62', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'567391989705493', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'30980780-7482-594a-a90d-88918483d50c', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'125451622877981', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'75d0be2b-184b-e445-a88b-8a1bc945da78', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'899514705051162', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'2acab785-3010-704e-8986-8d6c3e9dd98c', N'09cee92e-ef53-ca41-955b-745136e63b81', N'338008693830119', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'33f6124d-5948-d743-b339-8e4c7202020a', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'533419482812302', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'dfd46378-0c36-ad48-822f-91dd506f8da7', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'445810079707981', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd0034823-110a-c140-bea7-933cbf6fae00', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'968556777561539', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ae15f512-76a8-af4f-b052-9367c8bec217', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'408241322864373', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd23a0445-5542-3d48-b622-93fc9aab69af', N'f2fce050-6d26-0b45-9664-70287946c250', N'392361515190005', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'367b8842-dbfb-1c40-bb3c-944e0bad4343', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'832520498831993', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8aa0d9c0-c395-1943-b37d-9468a034d488', N'f2fce050-6d26-0b45-9664-70287946c250', N'655673874764885', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8b4e8ef8-c2ec-8b4b-b7a7-961c4e9af820', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'554214449175889', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'6f80ee6e-0fc0-944f-91ef-97716abeacc1', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'818616035611100', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'b26edb76-2ffe-d044-bffe-97c3550d6a75', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'66020491347516 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'cf017376-e50b-5548-aee3-987e26536081', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'395005976263251', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8e5ac46c-ae8a-a14e-9e6d-98b5da98049b', N'09cee92e-ef53-ca41-955b-745136e63b81', N'641398789624380', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'eb3f821e-bcbc-1b42-b8ba-9ba1edea4dc6', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'559789899189934', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'dbdb09dd-aeaf-5848-9506-a16daeacffbe', N'09cee92e-ef53-ca41-955b-745136e63b81', N'211803380005494', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'25363e4f-c619-6749-85ba-a177eead5e0f', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'965436854686214', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'44d9898d-3a4a-2848-9ac6-a1e3ce01770e', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'192260722881632', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'6de31381-e1d4-f94d-adef-a317d14b432b', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'128196447846194', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'af551895-ee8c-de4d-a693-a3c042081fbd', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'915838275763922', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1c56981a-c6a7-9e49-8b8f-a4134d1dd348', N'f2fce050-6d26-0b45-9664-70287946c250', N'340136753210950', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'4cb4f176-b6fc-9d4d-8dec-a4a13c4d9a79', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'31394075446983 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'80bddcfa-9962-974a-8dda-a4e15a49a0f7', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'186759644219732', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e55700d7-220c-e84c-ac7f-a5ccca9be5f8', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'252231124747702', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'0ac2e2a3-5749-a64c-99ac-a6fb105ed99e', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'341589757840372', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'4e56ba5b-be31-bf46-9abc-a8e4820b5865', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'541521133636868', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'9ccee8fd-cd60-496f-9441-a92cbc219859', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'543            ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'9d465127-a331-fa43-aca5-ab8d9958861c', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'515414773185517', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'fe180cb3-c9e2-e247-9021-ade221ff0899', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'57385404402259 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'544e0f80-14fd-bd45-a432-aef0c3587604', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'150443283891135', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'c6ec8936-8864-d343-859f-b054130787ef', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'921965063286727', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'9853a51e-44bd-c049-9240-b088568a4700', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'33850790061624 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'f9669b9a-1fe7-844e-8fae-b0a405469d32', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'682315025419245', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'2e25f8b6-08ba-7442-a575-b22a4c26ab25', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'56718620744456 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'bf21c2bc-8d4e-004b-81f9-b28c46e0785f', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'702557247679803', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'093375a1-b963-4c3e-8d14-b8c6d87cc0ff', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'91011          ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'212b67a5-04cd-0d49-8369-b961973abffb', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'95713904516632 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'a277d1e4-b135-6241-9b81-bbf6eaa85b30', N'09cee92e-ef53-ca41-955b-745136e63b81', N'142276283159096', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'07b4395b-586a-d54d-a607-beb34236f1be', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'52102968622698 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'289b9cb5-692d-e441-b6cb-bf4224dd0ec4', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'440248710873388', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'b3fd28ad-c43e-6a47-8e09-c30090a03f85', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'526552393769872', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'706b5fb0-a0d3-fa4f-8093-c41321e5a444', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'178976493382797', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'f42a9b39-3d46-8242-88d0-c619e5522e4a', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'60283146277507 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'095bebbb-8dad-8f44-b213-c786d6d40aa1', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'356621075997433', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'af7d1aef-6fc0-864c-9d07-c7c761bbf0ff', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'275916602267118', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'9cea40a0-714c-6848-839b-c95af8823451', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'535190245416630', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'565d2ced-818e-3e46-b77b-ca1292760d77', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'50013687650794 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'fa51f1c1-3a89-4548-ad60-cc1afd081c58', N'f2fce050-6d26-0b45-9664-70287946c250', N'241215670087727', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd48ce363-781f-fd44-8a16-cd41c2441466', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'105265394703029', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'25d84262-0fcb-eb44-98ee-cd4adb381d18', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'900637947443364', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'14cf1bdd-20a5-7349-befb-ce88dec3406b', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'870067751581498', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'2cd43308-6584-4e80-bb60-ce9e5e609460', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'5678           ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'5d4eb269-08a1-5449-8796-ceceea0d8275', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'660401463182228', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'de0c8f4a-4e1a-e840-9e0a-cefcf354787b', N'09cee92e-ef53-ca41-955b-745136e63b81', N'537505794847046', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'aee80bfe-7ab1-5345-b030-cf60b95e5de0', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'792041531695949', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'eab140f4-a64a-8c45-a010-cf98ee65c528', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'432040121948202', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'c7dcc5c2-d11b-af42-a095-cfff8ed45d18', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'25873197547067 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'fcc9ed69-1f49-3548-bf2e-d1c58c44c416', N'09cee92e-ef53-ca41-955b-745136e63b81', N'419109404983479', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8d611cfb-1036-1f40-bc28-d3d467592f53', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'342052681616976', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'876019ed-d9c8-9c4c-8ea3-d5870a690fd7', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'824159700445997', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'050d307e-e341-7d41-b0a2-d5b304181a40', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'248467028173424', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'0253b17e-ec1c-2641-b876-d6d4c1a6d2b6', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'374981717968005', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'17e2cbb9-a1a7-6948-a24b-d9590df6a929', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'329833972762007', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'b64cdcd6-ceae-b547-94a9-d9d55b071aab', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'373281252573207', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'a1688fb6-1a44-664a-9cf0-db5d21f43115', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'226368779208663', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e09e302d-e9ff-41b8-9ad2-db8fb21e931a', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'1234           ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'4e314af9-252e-9b4e-8d78-dd4865a0ac4b', N'd2528915-1e69-cc4d-b524-5c8559a33f09', N'587415827346578', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'3b3c5d22-fd2d-754c-8a64-dd8f009c55f5', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'598280865196518', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e2942ec4-9e85-814b-91e8-ddd944572e92', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'632912410066713', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'4cb370fe-9946-b346-a847-de203f7e8229', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'988449105423938', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7d2d8907-c0ac-9540-9a4e-df22e0b6b851', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'605334463982463', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ecf685fe-c53b-964a-872a-df37cb2c624e', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'365399185087878', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'491c7b96-b45a-5a4d-b9af-df79536fdb7a', N'09cee92e-ef53-ca41-955b-745136e63b81', N'544943773272413', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'11c683e5-280b-3748-89ba-e071168889f5', N'09cee92e-ef53-ca41-955b-745136e63b81', N'426319414616882', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'25d95335-bd7e-0a40-af10-e4743535301e', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'683109390737376', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'5bd76c25-5cc9-394e-8d4c-e527a365683e', N'09cee92e-ef53-ca41-955b-745136e63b81', N'143922918314096', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'88b62bf9-9273-ac40-8405-e6d33225e468', N'f2fce050-6d26-0b45-9664-70287946c250', N'617242431863370', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e2ff0fb1-b145-4449-9cb1-e7cb192e6be6', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'369075009548470', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'de98ebb3-ddbc-6042-999b-e7ffacb9630b', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'612925848640936', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'791e7115-e60a-d24b-98a1-ec2dcfa77003', N'f2fce050-6d26-0b45-9664-70287946c250', N'616492094935827', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'67d68a5b-0351-9443-bc76-ef098ad1ed9a', N'af0cffa8-e421-eb4b-b5f5-ea48d2f87031', N'135503573195158', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e7b633f5-9c63-e94f-8bb2-ef837b6e0708', N'd4ee5fa0-6cdb-054f-b444-9dd61403695b', N'89033889573453 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'60303c12-3923-134e-a688-f2c68b15fffe', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'130331904941628', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'2dd2780e-738d-734d-b1a7-f3eaec51ee36', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'200703882877503', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'b799645f-80a7-495e-895d-f43559a47c11', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'321            ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd61c12b4-8eae-c64b-a462-f45fd163eac2', N'f2fce050-6d26-0b45-9664-70287946c250', N'44685275141262 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'62ce3405-5df0-af42-ad45-f60087b97310', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'48128458015177 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'f78adbde-ddc1-9b49-b223-f6effc3fdf89', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'84466857951786 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1306ef97-7303-f24a-a5c5-f8312b8e528f', N'f2fce050-6d26-0b45-9664-70287946c250', N'910651430321706', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7324d7dc-1e5e-dd4a-bc1e-f8f5664037c5', N'bce3b811-d545-7240-9827-eeb6f8ec5a5b', N'77822891210344 ', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'c482aeb0-0374-8741-9594-f8fc7486517c', N'f2fce050-6d26-0b45-9664-70287946c250', N'234173860135981', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'5c5ea75b-814b-0947-9a58-f931269cd967', N'f2fce050-6d26-0b45-9664-70287946c250', N'692924566656469', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'07bdc1c6-cdbb-c049-9ddb-f949deede58e', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'705708462871836', 1, CAST(N'2023-04-05' AS Date), NULL)
GO
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8cb13e54-df9d-6c42-bdc3-f9a8ddf651b6', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'140016162335238', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'ce455aca-4308-4946-947b-fa9e191857c7', N'adeaf452-f1dc-4844-8add-2e167d5a3ce1', N'457380498785435', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'e93705e6-17fb-d741-a9eb-fd87be2e9c9d', N'6dfea2d5-9704-4b4d-aa69-0934bef2d9b4', N'138960231281106', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'7c69ea5f-16e6-a74f-bb57-ff13aa6160ca', N'156359a9-c377-834f-a1b3-4ad5c7b90032', N'700164320252046', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'1c4ed466-b9aa-d147-a471-ff5909b55db2', N'f2fce050-6d26-0b45-9664-70287946c250', N'288728858032159', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'81651ab6-f173-5549-b043-ff809c3263f4', N'09cee92e-ef53-ca41-955b-745136e63b81', N'148409880127428', 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[Imei] ([Id], [IdChiTietSP], [Ma], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'0c952a5c-b4f0-425a-9b24-ff98c5bca9fd', N'09cee92e-ef53-ca41-955b-745136e63b81', N'456            ', 1, CAST(N'2023-04-05' AS Date), NULL)
GO
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'21ca0127-946a-7c43-a5d1-0c6e5202a233', N'24889e2e-0be5-db45-ab76-61bf93530059', N'669270995978494', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'8cdff6fb-cc92-574f-ab66-430de86beaf6', N'9c32d31d-bf2f-964e-b426-8d23dfd08ee3', N'629477667821459', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd7499bab-b031-c849-833f-46f88c4833af', N'9dc2006e-63a8-2b40-87de-7a07f47cebcf', N'631472503394581', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'07be4bc5-0712-8744-ba88-553494739d78', N'b56646cb-82a1-784c-b486-203982176d0f', N'217332499116768', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'b45fca19-1e70-c643-9965-71d9b01efa9c', N'b2848e5a-344c-154e-919b-74497c2e8c04', N'645555999290362', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'4ee10651-5e09-9e4d-ae60-a1aa89d59179', N'3914cff4-0c11-4c49-9568-ba3699730019', N'158696918076323', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'823bf4b8-ac50-3349-9d17-ac7bee112f80', N'7236a43d-835f-9148-a282-ce7222eb1055', N'69027055779001 ', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'14174671-a631-564e-ae0e-b259064bda27', N'ba87be8d-e249-df4d-8f56-a77d063678a1', N'913978265930806', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'65de10cd-916e-4d4a-a7cf-b566e6cab414', N'9f0f2380-39db-3e44-b71b-19ee7d21b897', N'215743241414218', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[ImeiBan] ([Id], [IdHoaDonChiTiet], [Ma], [LyDo], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'71aa32ea-9591-3040-b5ed-d5f3d0088ad1', N'c66f494c-7990-d343-b9ec-c1d36aaba112', N'534399752409447', NULL, 1, CAST(N'2023-04-05' AS Date), NULL)
GO
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'f6422180-7fe3-974f-846b-0c01a0375eb1', N'KH20230405135133385', N'Nguyễn Văn Tý', 0, N'0987654329', N'Hà Nội', CAST(N'2002-04-28' AS Date), 1, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'49d5d745-cc0a-e641-a636-6a7d5680d841', N'KH20230405135034028', N'Nguyễn Văn Tất', 0, N'0923456789', N'Hà Nội', CAST(N'2000-04-01' AS Date), 0, NULL, CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'10e97662-a3da-7244-a0e7-72355e0abf84', N'KH20230405135112214', N'Nguyễn Văn Tú', 0, N'0987654325', N'Hà Nội', CAST(N'2003-04-12' AS Date), 0, NULL, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'6aab7aab-8ab4-cb4e-8d34-cc3d903190e8', N'KH20230405135057994', N'Nguyễn Thi Hậu', 1, N'0987654322', N'Hà Nội', CAST(N'2000-04-15' AS Date), 0, NULL, CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'3c953201-6a83-f045-aa56-d26405e65308', N'KH20230405135208142', N'Nguyễn Thi Tuyết', 1, N'0987654323', N'Hà Nội', CAST(N'2000-06-15' AS Date), 2, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'3843d0a0-c69f-4f42-868f-e80568131b32', N'KH20230405134955187', N'Nguyễn Văn Thành', 0, N'0987654321', N'Hà Nội', CAST(N'2000-04-12' AS Date), 0, NULL, CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'4f18cb1e-60a5-4abd-83a5-f4448f6164fe', N'MacDinh', N'Khách lẻ', 0, N'0', NULL, NULL, 4, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[KhachHang] ([Id], [Ma], [HoTen], [GioiTinh], [Sdt], [DiaChi], [NgaySinh], [CapDo], [NgayTutHang], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'17fa0f2e-daf2-964e-b4ff-f7b618722f50', N'KH20230405135147802', N'Nguyễn Văn Tuyền', 0, N'0987954329', N'Hà Nội', CAST(N'2005-04-28' AS Date), 1, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
GO
INSERT [dbo].[KhuyenMai] ([Id], [Ma], [Ten], [NgayBD], [NgayKT], [GiaTri], [TrangThai], [LoaiKM], [CreatedDate], [lastModifiedDate]) VALUES (N'3208f88a-137a-b248-8171-75642a9a0be8', N'KM20230405144357655', N'Sale Tháng 3', CAST(N'2023-03-01T01:30:00.000' AS DateTime), CAST(N'2023-03-31T02:30:00.000' AS DateTime), 1000000, 2, 1, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[KhuyenMai] ([Id], [Ma], [Ten], [NgayBD], [NgayKT], [GiaTri], [TrangThai], [LoaiKM], [CreatedDate], [lastModifiedDate]) VALUES (N'387e3ede-a21e-5f4a-bc88-9e66278071eb', N'KM20230405144433959', N'Sale tháng 5', CAST(N'2023-05-01T02:00:00.000' AS DateTime), CAST(N'2023-05-31T02:30:00.000' AS DateTime), 5, 0, 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[KhuyenMai] ([Id], [Ma], [Ten], [NgayBD], [NgayKT], [GiaTri], [TrangThai], [LoaiKM], [CreatedDate], [lastModifiedDate]) VALUES (N'a1147421-93f3-e84a-8190-dd84ba3ee35e', N'KM20230405144251213', N'Sale tháng 4', CAST(N'2023-04-01T01:00:00.000' AS DateTime), CAST(N'2023-04-30T01:30:00.000' AS DateTime), 10, 1, 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
GO
INSERT [dbo].[ManHinh] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'06fe5aa0-2433-054f-9c00-7da7713807b7', N'MH1', N'IPS', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ManHinh] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'f76a36c0-724b-3e4c-9cb0-a386af68dc7c', N'MH3', N'AMOLED', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ManHinh] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'0612a19a-d9a6-fb4b-b03a-ce98c875778a', N'MH4', N'LCD', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
INSERT [dbo].[ManHinh] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'addda214-ea11-6d4d-956c-f2e86b44346b', N'MH2', N'OLED', CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date), 0)
GO
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'd7cca0b3-ddd5-254e-9520-3525023f75d7', N'MS8', N'Trắng', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'5e33e6f9-d05d-d843-8933-4735054ad440', N'MS2', N'Đỏ', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'aa3152dd-ce66-3647-8329-6670d9eadaa9', N'MS6', N'Nâu', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'20f9e46a-6aab-c043-9dd8-96c75f3ea644', N'MS1', N'Xanh', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'dc7713de-57de-1043-91e9-9abc6e135381', N'MS4', N'Vàng', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'9d196202-b81b-7c47-85ff-bca5d3509a5b', N'MS7', N'Đen', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'9a51f8c1-060f-b843-ac3f-d47f2616a717', N'MS3', N'Tím', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'8a7c7b92-c2ff-7646-b2e8-f6a4c2210c45', N'MS5', N'Hồng', CAST(N'2023-04-05' AS Date), NULL, 0)
GO
INSERT [dbo].[Pin] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'18f2f6f2-38ed-2749-87e4-58a34c9e983c', N'PI5', N'2000mAh', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Pin] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'b16a908d-2102-a249-b72e-b1e459d31586', N'PI3', N'4000mAh', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Pin] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'69f23364-149f-cc47-af67-c06e5f029622', N'PI2', N'5000mAh', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Pin] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'f34f5ada-a473-7146-ad27-c78eb80292a3', N'PI4', N'3000mAh', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Pin] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'4083a735-7d35-b24b-9623-d315679ad0f5', N'PI1', N'6000mAh', CAST(N'2023-04-05' AS Date), NULL, 0)
GO
INSERT [dbo].[Ram] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'1a5c326a-0510-6f4b-a88a-5bab9354bee8', N'RA2', N'10GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Ram] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'd9909b6c-7a60-654c-b0aa-770a1a961fc4', N'RA6', N'3GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Ram] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'fad6586a-6980-4f4e-adbe-9974f0da74bd', N'RA3', N'8GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Ram] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'830a2d87-02fb-8842-b0df-a58711e0116c', N'RA1', N'12GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Ram] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'2c743540-5dd3-0448-82d7-c994857e0bba', N'RA7', N'2GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Ram] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'f3e10265-d871-2148-b666-e11f64db2aa5', N'RA4', N'6GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Ram] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'89b39aea-4b33-0244-9abf-f8fd735a0598', N'RA5', N'4GB', CAST(N'2023-04-05' AS Date), NULL, 0)
GO
INSERT [dbo].[Rom] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'c67a0ddf-48c4-ba4f-8a87-59b5a6c5ff04', N'RO5', N'16GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Rom] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'c25c5e59-a58a-b545-85c4-6f6c368f707b', N'RO4', N'32GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Rom] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'0d6b2aff-c49c-624a-ab9c-ab18cd1a7902', N'RO1', N'256GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Rom] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'71d6aca1-420c-6c44-aa4e-c80be126b7af', N'RO3', N'64GB', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[Rom] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'09f09a12-28ac-db48-aca4-d391d8c77821', N'RO2', N'128GB', CAST(N'2023-04-05' AS Date), NULL, 0)
GO
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'a59a3c9f-af4d-c146-84a6-38ecaa48bdb7', N'SP20230405141440065', N'Iphone 6', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'ccec3327-e968-9445-a14e-3dc2e85c221a', N'SP20230405141821798', N'Oppo A3', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'3e67b514-8d2c-af43-8896-78ff3f205c8c', N'SP20230405141855649', N'Iphone 12', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'aeaef4ae-0ec4-9042-a381-87b00183c819', N'SP20230405141708145', N'SamSung J7', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'9d97a06f-7845-4845-ad4d-94961de8b643', N'SP20230405141630242', N'Iphone 6 Plus', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'573ec3d3-82fa-8242-863d-a70b238e1bf9', N'SP20230405141314774', N'Iphone 8 Plus', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'0ffd41eb-2e4b-d84a-9d15-b331d8c5ae44', N'SP20230405142020862', N'Xiaomi Mi 8', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'884bf2ed-9e0b-f948-a1b9-c6216de927fd', N'SP20230405142057966', N'Vinmart Live 4', CAST(N'2023-04-05' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten], [CreatedDate], [lastModifiedDate], [Deleted]) VALUES (N'1a7d0f59-8b41-e44c-966d-cfa775911e92', N'SP20230405141937299', N'SamSung A7', CAST(N'2023-04-05' AS Date), NULL, 0)
GO
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'df223f38-abda-5d4c-bc6f-3736ccc8cc26', N'NV004', N'Nguyễn Anh Tuấn', 0, CAST(N'2003-06-23' AS Date), N'Hà Nam', N'tuan03@gmail.com', N'0927366783', N'1685CE5EC5EC054D28F395200D8A4F5D', 1, N'NV002', 0, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'9c9f4ab8-4178-cf49-8226-3e05efdc99bf', N'NV001', N'Triệu Văn Tưởng', 0, CAST(N'2003-11-11' AS Date), N'Hưng Yên', N'gaupanda567@gmail.com', N'0923264752', N'21232f297a57a5a743894a0e4a801fc3', 0, N'NV001', 0, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'd617f4df-4b1b-41e4-872e-ad6004900553', N'NV007', N'Admin', 0, CAST(N'2003-01-01' AS Date), N'Hà Nội', N'admin@gmail.com', N'0123456789', N'21232f297a57a5a743894a0e4a801fc3', 0, N'NV001', 0, CAST(N'2023-01-01' AS Date), NULL)
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'085e0233-10d2-4171-880e-48020830efc0', N'NV008', N'NhanVien', 0, CAST(N'2003-01-01' AS Date), N'Hà Nội', N'nhanvien@gmail.com', N'0123456789', N'2a2fa4fe2fa737f129ef2d127b861b7e', 1, N'NV002', 0, CAST(N'2023-01-01' AS Date), NULL)
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'6cb2a44d-a0b5-1146-9156-60fbe677b8bf', N'NV003', N'Nguyễn Văn Nhật', 0, CAST(N'2003-02-23' AS Date), N'Thanh Hóa', N'nhat03@gmail.com', N'0927366753', N'7464022B39B5CABCD7C4DBDA3C927F56', 1, N'NV002', 0, CAST(N'2023-04-05' AS Date), NULL)
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'004f08fe-e1ca-d340-9b9f-d502c27aab36', N'NV006', N'Lương Thị Tuyến', 1, CAST(N'2003-04-23' AS Date), N'Hà Nội', N'tuyen03@gmail.com', N'0985366934', N'C126A6CAED4EE1C7F10CACF326DB1A0B', 1, N'NV002', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'acfbe3e5-2e9a-de4a-80d9-d8a61e151f24', N'NV005', N'Nguyễn Thị Phương Oanh', 1, CAST(N'2003-08-23' AS Date), N'Hà Nội', N'oanh03@gmail.com', N'0927366934', N'EC4C87922CD4CCC04A5DD11B12D971EA', 1, N'NV002', 0, CAST(N'2023-04-05' AS Date), CAST(N'2023-04-05' AS Date))
INSERT [dbo].[TaiKhoan] ([Id], [Ma], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [Email], [Sdt], [MatKhau], [ChucVu], [HinhAnh], [TrangThai], [CreatedDate], [lastModifiedDate]) VALUES (N'cbdb3b50-e774-2747-9db4-e0ad54efd00c', N'NV002', N'Nguyễn Văn Kiên', 0, CAST(N'2003-01-23' AS Date), N'Thanh Hóa', N'kien03@gmail.com', N'0927364753', N'a916938188dc916c35fba826dd78633b', 1, N'NV002', 0, CAST(N'2023-04-05' AS Date), NULL)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__BaoHanh__3214CC9E40BF55C3]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[BaoHanh] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__CPU__3214CC9EAA17FE3B]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[CPU] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__HoaDon__3214CC9E1B6BC79A]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[HoaDon] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Imei__3214CC9EA7CA0638]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[Imei] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhachHan__3214CC9EAB7DF4FD]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[KhachHang] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhuyenMa__3214CC9E416175B0]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[KhuyenMai] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ManHinh__3214CC9E03545C14]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[ManHinh] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__MauSac__3214CC9EE8A6918A]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[MauSac] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Pin__3214CC9EC664779A]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[Pin] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Ram__3214CC9EA663E7BD]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[Ram] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Rom__3214CC9E499E30E0]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[Rom] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__SanPham__3214CC9E36B52DAB]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[SanPham] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__TaiKhoan__3214CC9EE07C6A84]    Script Date: 05-Apr-23 14:59:46 ******/
ALTER TABLE [dbo].[TaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (NULL) FOR [NgayHoanThanh]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (NULL) FOR [NgayKhachLay]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[BaoHanh] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [LoaiHang]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [Gia]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [SoLuong]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[CPU] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayThanhToan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayNhanHang]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayShip]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayNhanMongMuon]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TienShip]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TienThua]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TienMat]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [ChuyenKhoan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [TenKH]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TongTien]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [SoLanShip]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [SdtNguoiShip]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [SdtNguoiNhan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [LoaiThanhToan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [GiamGia]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((0)) FOR [DonGia]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((0)) FOR [Thanhtien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((0)) FOR [KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[Imei] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[Imei] ADD  DEFAULT (NULL) FOR [IdChiTietSP]
GO
ALTER TABLE [dbo].[Imei] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[Imei] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[Imei] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[ImeiBan] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ImeiBan] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ImeiBan] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[ImeiBan] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [CapDo]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (getdate()) FOR [NgayTutHang]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [GiaTri]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [LoaiKM]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[ManHinh] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[Pin] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[Pin] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[Pin] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[Pin] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[Ram] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[Ram] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[Ram] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[Ram] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[Rom] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[Rom] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[Rom] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[Rom] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT ((0)) FOR [Deleted]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (NULL) FOR [HoTen]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT ((0)) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT ((0)) FOR [ChucVu]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (NULL) FOR [lastModifiedDate]
GO
ALTER TABLE [dbo].[BaoHanh]  WITH CHECK ADD FOREIGN KEY([IdImei])
REFERENCES [dbo].[Imei] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdCPU])
REFERENCES [dbo].[CPU] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdManHinh])
REFERENCES [dbo].[ManHinh] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdPin])
REFERENCES [dbo].[Pin] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdRam])
REFERENCES [dbo].[Ram] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdRom])
REFERENCES [dbo].[Rom] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdSP])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdKH])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdTK])
REFERENCES [dbo].[TaiKhoan] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdChiTietSP])
REFERENCES [dbo].[ChiTietSP] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdHoaDon])
REFERENCES [dbo].[HoaDon] ([Id])
GO
ALTER TABLE [dbo].[Imei]  WITH CHECK ADD FOREIGN KEY([IdChiTietSP])
REFERENCES [dbo].[ChiTietSP] ([Id])
GO
ALTER TABLE [dbo].[ImeiBan]  WITH CHECK ADD FOREIGN KEY([IdHoaDonChiTiet])
REFERENCES [dbo].[HoaDonChiTiet] ([Id])
GO
