<?php
include("config.php");

$judul_berita = $_POST['judul_berita'];
$waktu_berita = $_POST['waktu_berita'];
$penulis_berita = $_POST['penulis_berita'];
$isi_berita = $_POST['isi_berita'];



	$sql = "INSERT INTO berita ( judul_berita, waktu_berita, penulis_berita, isi_berita ) VALUES ('$judul_berita', '$waktu_berita', '$penulis_berita', '$isi_berita' )";
	$query = mysqli_query($db, $sql);

if($query){
    echo json_encode(array('message'=>'student data successfully added.'));
  }else{
    echo json_encode(array('message'=>'student data failed to add.'));
  }

?>