import { useEffect, useState } from "react";
import "./App.css";
function App() {
  const [students, setStudents] = useState([]);
  const [student, setStudent] = useState({
    id: "",
    name: "",
    email: "",
    course: ""
  });
  const [isEdit, setIsEdit] = useState(false);
  // get all students
  const getStudents = () => {
    fetch("http://localhost:8086/students/allStudents")
      .then((response) => response.json())
      .then((data) => {
        setStudents(data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  // page loading
  useEffect(() => {
    getStudents();
  }, []);
  // handle change
  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setStudent({
      ...student,
      [name]: value
    });
  };
  // add student
  const addStudent = () => {
    fetch("http://localhost:8086/students/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({

  name: student.name,

  email: student.email,

  course: student.course

})
    })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      getStudents();
      clearForm();
    })
    .catch((error) => {
      console.log(error);
    });
  };
  // delete student
  const deleteStudent = (id) => {
    fetch(`http://localhost:8086/students/delete/${id}`, {
      method: "DELETE"
    })
    .then(() => {
      getStudents();
    })
    .catch((error) => {
      console.log(error);
    });
  };
  // Edit student
  const editStudent = (s) => {
    setStudent(s);
    setIsEdit(true);
  };
  // update student
  const updateStudent = () => {
    fetch(`http://localhost:8086/students/update/${student.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(student)
    })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      getStudents();
      clearForm();
      setIsEdit(false);
    })
    .catch((error) => {
      console.log(error);
    });
  };
  // clear form
  const clearForm = () => {
    setStudent({
      id: "",
      name: "",
      email: "",
      course: ""
    });
  };
  return (
    <div className="container">
      <div className="form-box">
        <h1>Student Management System</h1>
        <input type="text" name="name" placeholder="Enter Name" value={student.name} onChange={handleChange}/>
        <input type="text" name="email" placeholder="Enter Email" value={student.email} onChange={handleChange}/>
        <input type="text"  name="course" placeholder="Enter Course" value={student.course} onChange={handleChange}/>
        {
          isEdit ?
          <button onClick={updateStudent}> Update Student</button>
          :
          <button onClick={addStudent}>Add Student</button>
        }
      </div>
      <div className="table-box">
        <h2>All Students</h2>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Course</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {
              students.map((s) => (
                <tr key={s.id}>
                  <td>{s.id}</td>
                  <td>{s.name}</td>
                  <td>{s.email}</td>
                  <td>{s.course}</td>
                  <td>
                    <button className="edit-btn"  onClick={() => editStudent(s)}>Edit</button>
                    <button   className="delete-btn"
                      onClick={() => deleteStudent(s.id)} > Delete </button>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
    </div>
  );
}
export default App;