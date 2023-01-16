Student:
Get:	StudentResponseDTO getStudentById(int id)
	List<StudentDTO> getAllStudents();

Post:	Student saveStudent(Student student)

Put:	Student updateStudent(Student student, int id)

Delete:	void deleteStudent(int id)
	

Teacher:
Get:	TeacherResponseDTO getTeacherById(long id)
	List<TeacherDTO> getAllTeacher();

Post:	Teacher saveTeacher(Teacher teacher)

Put:	Teacher updateTeacher(Teacher teacher, int id)

Delete:	void deleteTeacher(int id)