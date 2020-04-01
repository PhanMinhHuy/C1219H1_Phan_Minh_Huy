use furama_resort;

/*taks 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự 
“H”, “T” hoặc “K” và có tối đa 15 ký tự. */

select * from nhan_vien
where (ho_ten like "K%" or ho_ten like "H%" or ho_ten like "T%") and length(ho_ten) <= 15;

/* task 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi
và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”. */

-- cách 1
select * from khach_hang
where ((year(curdate()) - year(ngay_sinh)) between 18 and 50) and (dia_chi = 'Da Nang' or dia_chi = 'Quang tri');

 -- cách 2
select * from khach_hang
where (timestampdiff(YEAR, ngay_sinh, curdate()) between 18 and 50) and (dia_chi = "Quang Tri" or dia_chi = "Da Nang");

/* task 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”. */

select khach_hang.*, hop_dong.id_hop_dong,  count(hop_dong.id_hop_dong) as 'so_lan_dat_phong'
from khach_hang
inner join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang 
inner join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
where loai_khach.ten_loai_khach = 'Diamond'
group by khach_hang.ho_ten
order by 'so_lan_dat_phong';

/*task 5. Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/

select khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.id_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, dich_vu.ten_dich_vu, (dich_vu.chi_phi_thue + dich_vu_di_kem.don_vi * dich_vu_di_kem.gia) as tong_tien
from khach_hang
left join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
order by id_khach_hang;

/*task 6. Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

select id_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
where id_dich_vu not in
( 	select dich_vu.id_dich_vu 
	from dich_vu
    inner join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
    where ngay_lam_hop_dong >= '2019-01-01'
);

/*task 7. Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.*/

select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
inner join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where (year(ngay_lam_hop_dong) = 2018) and
dich_vu.id_dich_vu not in
( 	select dich_vu.id_dich_vu 
	from dich_vu
    inner join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
    where year(ngay_lam_hop_dong) = 2019
);

/*task 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/

-- Cach 1:
select ho_ten from khach_hang
group by ho_ten;

-- Cach 2:
select distinct ho_ten from khach_hang;

-- Cach 3:
select khach_hang.ho_ten from khach_hang
union select khach_hang.ho_ten from khach_hang;

/*task 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 
2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

select id_hop_dong, month(ngay_lam_hop_dong) as thang, count(id_hop_dong) as so_lan_dat
from hop_dong
where year(ngay_lam_hop_dong) = 2019
group by thang;

/*task 10. Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).*/

select hop_dong.id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, count(id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem
from hop_dong
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
group by id_hop_dong;

/*task 11. Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/

select dich_vu_di_kem.*
from dich_vu_di_kem
inner join hop_dong_chi_tiet using(id_dich_vu_di_kem)
inner join hop_dong using(id_hop_dong)
inner join khach_hang using(id_khach_hang)
inner join loai_khach using(id_loai_khach)
where loai_khach.ten_loai_khach = 'Diamond' and (khach_hang.dia_chi = 'Vinh' or khach_hang.dia_chi = 'Quang Ngai')
group by id_dich_vu_di_kem;

/*task 12. Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng 
đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/

select hop_dong.id_hop_dong, nhan_vien.ho_ten as ten_nhan_vien, khach_hang.ho_ten as ten_khach_hang,
khach_hang.sdt, dich_vu.ten_dich_vu, hop_dong.tien_dat_coc, count(id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem
from hop_dong
inner join nhan_vien using(id_nhan_vien)
inner join khach_hang using(id_khach_hang)
inner join dich_vu using(id_dich_vu)
inner join hop_dong_chi_tiet using(id_hop_dong)
where (hop_dong.ngay_lam_hop_dong between '2019-10-01' and '2019-12-31') and hop_dong.id_hop_dong not in (
	select hop_dong.id_hop_dong
	from hop_dong
	inner join hop_dong_chi_tiet using(id_hop_dong)
	where ngay_lam_hop_dong between '2019-01-01'  and '2019-06-30'
)
group by id_hop_dong;

/*task 13. Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
 (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
 
select dich_vu_di_kem.*, count(id_dich_vu_di_kem) as so_lan_dat
from dich_vu_di_kem
inner join hop_dong_chi_tiet using(id_dich_vu_di_kem)
inner join hop_dong using (id_hop_dong)
group by id_dich_vu_di_kem
order by so_lan_dat desc;

/*task 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/

select hop_dong.id_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong
inner join dich_vu using (id_dich_vu)
inner join loai_dich_vu using (id_loai_dich_vu)
inner join hop_dong_chi_tiet using (id_hop_dong)
inner join dich_vu_di_kem using (id_dich_vu_di_kem)
group by id_dich_vu_di_kem
having so_lan_su_dung = 1;

/*task 15. Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/

select id_nhan_vien, ho_ten,sdt, dia_chi ,trinh_do.trinh_do, bo_phan.ten_bo_phan, count(id_nhan_vien) as so_hop_dong_lap_nam_18_19
from nhan_vien
inner join trinh_do using (id_trinh_do)
inner join bo_phan using (id_bo_phan)
inner join hop_dong using (id_nhan_vien)
where year(ngay_lam_hop_dong) between 2018 and 2019
group by id_nhan_vien
having so_hop_dong_lap_nam_18_19 >= 3;

-- task 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

alter table hop_dong drop FOREIGN KEY fk_nhan_vien;
alter table hop_dong add constraint fk_nhan_vien FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien) on delete cascade;
delete from nhan_vien 
where id_nhan_vien not in 
(
	select id_nhan_vien 
    from hop_dong
    where year(ngay_lam_hop_dong) between 2017 and 2019
    group by id_nhan_vien
);

/*task 17. Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.*/

