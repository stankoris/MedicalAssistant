<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Technician dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
</head>
<body>
    <form action="technician/patient/new" method="post" enctype="multypart/form-data"></form>
    <div>
        <label>First name</label>
        <input type="text" name="first_name">
    </div>
    <div>
        <label>Last name</label>
        <input type="text" name="last_name">
    </div>
    <div>
        <label>Date of birth</label>
        <input type="date" name="date_of_birth">
    </div>
    <div>
        <label>E-mail</label>
        <input type="text" name="email">
    </div>
    <div>
        <label>Jmbg</label>
        <input type="text" name="jmbg" oninput="validateNumber(this)" maxlength="13">
    </div>
    <div>
        <button type="submit">Save</button>
    </div>




     <textarea id="sample">Hi</textarea>

    
    <script src="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/suneditor.min.js"></script>
    <script>
        const editor = SUNEDITOR.create((document.getElementById('sample')),{});
    </script>


    <script>
        function validateNumber(input) {
            input.value = input.value.replace(/[^0-9]/g, ''); // Uklanja sve osim brojeva
            if (input.value.length > 13) {
                input.value = input.value.slice(0, 13); // Ograničava dužinu na 13 cifara
            }
        }
    </script>
</body>
</html>