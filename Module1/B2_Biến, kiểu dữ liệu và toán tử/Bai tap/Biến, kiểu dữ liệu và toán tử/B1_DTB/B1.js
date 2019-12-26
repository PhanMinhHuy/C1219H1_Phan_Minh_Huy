let diemToan = parseFloat()e(prompt("Nhap diem Toan: ")) ;
document.write("Diem Toan: " + diemToan + "<br>");

let diemLy = parseFloat(prompt("Nhap diem Ly: "));
document.write("Diem Ly: " + diemLy + "<br>");

let diemHoa = parseFloat(prompt("Nhap diem Hoa: "));
document.write("Diem Hoa: " + diemHoa + "<br>");

let diemTb = (diemToan + diemLy + diemHoa) / 3;

document.write("Diem trung binh: " + diemTb);





