# Assignment-1
This Java program, by Tat Putjorn (672115024), is designed to sort and search student information from CSV files. The system requires a properly formatted CSV file with at least 7 header lines and student records containing index, student ID, first name, and last name. To use the program, place both Java files (SortingMain.java and StudentsName.java) along with your CSV file in the same directory, then compile them using javac StudentsName.java and javac SortingMain.java. Run the program with java SortingMain, and follow the prompts to enter your CSV filename and choose your desired option: -n (sort by student ID), -f (sort by first name), -l (sort by last name), or -s (search by first name). The program uses bubble sort for sorting and includes a case-insensitive search function for finding students by their first name.

Example Outputs by sorting by student number and searching by first name : 

Enter the file name: class_roaster67.csv
File successfully loaded!
Enter the sorting/search option (-n, -f, -l, -s): -n

Sorted Students:
622115040 SUCHANUN SIRIJANYA
662115007 CHONCHANUN KHACHONPHURITHANAKUL
662115016 NATTHAPHUM CHAIKHAN
662115039 MANAPAT KAEWLAI
672115001 KATIKA KANTHASON
672115002 KRITTAMETH TANSUWAN
672115004 JITTIPAT KAEWIJIT
672115005 CHETSADA KANKARN
672115006 CHANLACHAT PANYOYAI
672115007 CHANCHAKORN JULLAPECH
672115008 CHANYA BUNRUEANG
672115009 CHIDNUCHA POBKEEREE
672115010 NATANON SOMBOON
672115011 NATTHAPOOM SAENGKAEW
672115012 NUT SUPAPORN
672115013 NATTHAN CHAMPATHIP
672115014 NATTIKORN SAE-SUE
672115015 NATTAPON SUKKEAW
672115016 NATTHAPAT JAGKHURUANG
672115018 DALANPHOP KEAWSIRIPONG
672115019 THINNAPOP SRISOMBOON
672115020 TECHIT WONGKITI
672115024 TAT PUTJORN
672115028 NINA BURGER
672115037 PHUTAWAN MUEANGMA
672115039 METAVEE AEINJANG
672115041 RAPHEEPHAT AEIPHINGCHAI
672115042 RANTICHA CHUMJAI
672115043 WASINPAT YANIN
672115044 VIDCHAYADA ABHICHARTTIBUTRA
672115045 VIRAWIT KONGTHONG
672115046 SATTAPORN KOWARAKUN
672115047 SAMAKOM MAKHIAO
672115048 SUKRITPONG WONGPANYA
672115049 ANAWAT JANDEE

Enter the file name: class_roaster67.csv
File successfully loaded!
Enter the sorting/search option (-n, -f, -l, -s): -s
Enter the first name to search: TAT
The name TAT was found at index 22

