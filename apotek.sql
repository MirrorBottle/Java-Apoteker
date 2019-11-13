-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2019 at 12:39 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek`
--

-- --------------------------------------------------------

--
-- Table structure for table `agen`
--

CREATE TABLE `agen` (
  `id_agen` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agen`
--

INSERT INTO `agen` (`id_agen`, `nama`) VALUES
(1, 'Dukun Terpecaya'),
(2, 'Mak Lampir Corp.'),
(3, 'Penyelundup Obat Legal');

-- --------------------------------------------------------

--
-- Table structure for table `apoteker`
--

CREATE TABLE `apoteker` (
  `id_apoteker` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `password` varchar(191) NOT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(191) NOT NULL,
  `no_telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apoteker`
--

INSERT INTO `apoteker` (`id_apoteker`, `nama`, `password`, `jenis_kelamin`, `alamat`, `email`, `no_telp`) VALUES
(1, 'Wota', '12345', 'Perempuan', 'Jl. Mantan', 'WotaWota@gmail.com', '12345678'),
(2, 'Baka', '12345', 'Perempuan', 'Jl. Kenangan Terindah', 'EhNani@gmail.com', '12345678'),
(3, 'Yamai', '12345', 'Perempuan', 'Jl. Zaman kegelapan', 'MeGaMeGa@gmail.com', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `gudang`
--

CREATE TABLE `gudang` (
  `id_penyimpanan` int(11) NOT NULL,
  `id_obat` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `penambahan_terakhir` date NOT NULL,
  `pengambilan_terakhir` date NOT NULL DEFAULT '0000-00-00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gudang`
--

INSERT INTO `gudang` (`id_penyimpanan`, `id_obat`, `stock`, `penambahan_terakhir`, `pengambilan_terakhir`) VALUES
(1, 3, 2525, '2019-10-12', '2019-10-23'),
(4, 7, 100, '2019-11-13', '2019-11-13');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL,
  `nama_obat` varchar(100) DEFAULT NULL,
  `komposisi_obat` text,
  `merk_obat` varchar(255) DEFAULT NULL,
  `dosis_obat` varchar(255) DEFAULT NULL,
  `satuan` varchar(15) NOT NULL,
  `harga` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `komposisi_obat`, `merk_obat`, `dosis_obat`, `satuan`, `harga`) VALUES
(1, 'Pelet Tingkat Tinggi', 'paku, rumput, kaki kambing', 'Dukun Terpercaya', '2 x Sehari', 'keping', 4000),
(2, 'Penambah Kekebalan Santet', 'Rambut Mak Lampir, Ekor Cicak, Kaki Kuda Betina Liar', 'Mak Lampir Corp.', '3 x Seminggu', 'botol', 0),
(3, 'Auto Dapat Jodoh', 'Usaha, Kerja Keras, Doa, Niat, dll', 'PT. Kata-Kata Mutiara', '7 x Seminggu', 'keping', 7000),
(7, 'adwadwa', 'awda', 'awda', '45 x Dua Hari', 'Tube', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `id_pembeli` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `tanggal_pembelian` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tanggal_menerima` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`id_pembeli`, `nama`, `alamat`, `tanggal_pembelian`, `tanggal_menerima`) VALUES
(1, 'Agus Subekti', 'Jl. TIdak Selingkuh', '2019-10-07 00:07:43', '0000-00-00 00:00:00'),
(2, 'Martha', 'Jl. Kepemilikan', '2019-10-07 00:04:38', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `pengiriman_obat`
--

CREATE TABLE `pengiriman_obat` (
  `id_pengiriman` int(11) NOT NULL,
  `id_agen` int(11) DEFAULT NULL,
  `id_apoteker` int(11) DEFAULT NULL,
  `tanggal_pengiriman` date NOT NULL,
  `id_obat` int(11) DEFAULT NULL,
  `total_obat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengiriman_obat`
--

INSERT INTO `pengiriman_obat` (`id_pengiriman`, `id_agen`, `id_apoteker`, `tanggal_pengiriman`, `id_obat`, `total_obat`) VALUES
(1, 1, 2, '2019-10-07', 3, 1000),
(2, 1, 2, '2019-10-14', 7, 3000),
(3, 3, 2, '2019-10-14', 3, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan_obat`
--

CREATE TABLE `penjualan_obat` (
  `id_penjualan` int(11) NOT NULL,
  `id_pembeli` int(11) DEFAULT NULL,
  `id_apoteker` int(11) DEFAULT NULL,
  `id_resep` int(11) DEFAULT NULL,
  `tanggal_pembelian` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `total_pembelian` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan_obat`
--

INSERT INTO `penjualan_obat` (`id_penjualan`, `id_pembeli`, `id_apoteker`, `id_resep`, `tanggal_pembelian`, `total_pembelian`) VALUES
(1, 1, 2, 3, '2019-10-07 00:15:24', 80000),
(2, 1, 2, 4, '2019-10-07 00:15:24', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE `resep` (
  `id_resep` int(11) NOT NULL,
  `id_pembeli` int(11) NOT NULL,
  `keterangan` text,
  `id_obat` int(11) DEFAULT NULL,
  `jumlah_obat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resep`
--

INSERT INTO `resep` (`id_resep`, `id_pembeli`, `keterangan`, `id_obat`, `jumlah_obat`) VALUES
(3, 1, 'Gak perlu tau', 3, 12),
(4, 1, 'Gak Perlu Tau', 1, 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agen`
--
ALTER TABLE `agen`
  ADD PRIMARY KEY (`id_agen`);

--
-- Indexes for table `apoteker`
--
ALTER TABLE `apoteker`
  ADD PRIMARY KEY (`id_apoteker`);

--
-- Indexes for table `gudang`
--
ALTER TABLE `gudang`
  ADD PRIMARY KEY (`id_penyimpanan`),
  ADD KEY `id_obat` (`id_obat`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`id_pembeli`);

--
-- Indexes for table `pengiriman_obat`
--
ALTER TABLE `pengiriman_obat`
  ADD PRIMARY KEY (`id_pengiriman`),
  ADD KEY `id_agen` (`id_agen`),
  ADD KEY `id_apoteker` (`id_apoteker`,`id_obat`),
  ADD KEY `id_obat` (`id_obat`);

--
-- Indexes for table `penjualan_obat`
--
ALTER TABLE `penjualan_obat`
  ADD PRIMARY KEY (`id_penjualan`),
  ADD KEY `id_pembeli` (`id_pembeli`),
  ADD KEY `id_apoteker` (`id_apoteker`,`id_resep`),
  ADD KEY `id_resep` (`id_resep`);

--
-- Indexes for table `resep`
--
ALTER TABLE `resep`
  ADD PRIMARY KEY (`id_resep`),
  ADD KEY `id_pembeli` (`id_pembeli`,`id_obat`),
  ADD KEY `id_obat` (`id_obat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agen`
--
ALTER TABLE `agen`
  MODIFY `id_agen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `apoteker`
--
ALTER TABLE `apoteker`
  MODIFY `id_apoteker` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `gudang`
--
ALTER TABLE `gudang`
  MODIFY `id_penyimpanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `id_pembeli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pengiriman_obat`
--
ALTER TABLE `pengiriman_obat`
  MODIFY `id_pengiriman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `penjualan_obat`
--
ALTER TABLE `penjualan_obat`
  MODIFY `id_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `resep`
--
ALTER TABLE `resep`
  MODIFY `id_resep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gudang`
--
ALTER TABLE `gudang`
  ADD CONSTRAINT `gudang_ibfk_2` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`);

--
-- Constraints for table `pengiriman_obat`
--
ALTER TABLE `pengiriman_obat`
  ADD CONSTRAINT `pengiriman_obat_ibfk_1` FOREIGN KEY (`id_agen`) REFERENCES `agen` (`id_agen`),
  ADD CONSTRAINT `pengiriman_obat_ibfk_2` FOREIGN KEY (`id_apoteker`) REFERENCES `apoteker` (`id_apoteker`),
  ADD CONSTRAINT `pengiriman_obat_ibfk_3` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`);

--
-- Constraints for table `penjualan_obat`
--
ALTER TABLE `penjualan_obat`
  ADD CONSTRAINT `penjualan_obat_ibfk_1` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`),
  ADD CONSTRAINT `penjualan_obat_ibfk_2` FOREIGN KEY (`id_apoteker`) REFERENCES `apoteker` (`id_apoteker`),
  ADD CONSTRAINT `penjualan_obat_ibfk_3` FOREIGN KEY (`id_resep`) REFERENCES `resep` (`id_resep`);

--
-- Constraints for table `resep`
--
ALTER TABLE `resep`
  ADD CONSTRAINT `resep_ibfk_1` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`),
  ADD CONSTRAINT `resep_ibfk_2` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
