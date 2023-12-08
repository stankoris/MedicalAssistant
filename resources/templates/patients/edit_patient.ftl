<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form id="new_patient_form" action="/technician/edit/${patient.patient_id}" method="post" enctype="multipart/form-data">
        <div>
            <label>First name</label>
            <input type="text" name="full_name" value="${patient.first_name}" />
        </div>
        <div>
            <label>Last name</label>
            <input type="text" name="last_name" value="${patient.last_name}">
        </div>
        <div>
            <label>Date of birth</label>
            <input type="date" name="date_of_birth" min="1900-01-01" max="2023-11-27" value='${patient.date_of_birth!""}'>
        </div>
        <div>
            <label>Address</label>
            <input type="text" name="address" value='${patient.address!""}'>
        </div>
        <div>
            <label>E-mail</label>
            <input type="email" name="email" value='${patient.email!""}'>
        </div>
        <div>
            <label>Jmbg</label>
            <input type="text" name="jmbg" oninput="validateNumber(this)" maxlength="13" value="${patient.jmbg}">
        </div>
        <div>
            <label>Phone number</label>
            <input type="number" name="phone_number" value='${patient.date_of_birth!""}'>
        </div>
            <button type="submit">Update</button>
        </div>
    </form>

    <script>
        const new_patient_form = document.getElementById("new_patient_form")
        new_patient_form.onsubmit = () => {
            const html_content = editor.getContents(true);
        }
    </script>
</body>
</html>