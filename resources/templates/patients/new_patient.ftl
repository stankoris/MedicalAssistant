<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New patient</title>
    <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/new_patient.css">
</head>
<body>

    <#if savePatient?has_content>
        <script>
            <#if savePatient == "true">
                alert("Patient has been saved successfully!");
                window.location.href = "/technician";
            <#else>
                alert("There was an error saving patient!");
            </#if>
        </script>
    </#if>

    <#if jmbg?has_content>
        <script>
            <#if jmbg == "true">
                alert("There is already a patient with that JMBG! Please enter a new JMBG!");
                window.history.back();
            </#if>
        </script>
    </#if>

<header>
    <h1><a href="/technician">MedicalAssistant</a></h1>

    <div class="container">
     <button id="showOptionsBtn" ><i class="fa-solid fa-bars"></i></button>
        <div class="options-container" id="optionsContainer">
            <a href="/technician/all_patients">All patients</a>
            <a href="/technician/find_patients">Find patient</a>
            <a href="/technician/new_patient">New patient</a>
        </div>
    </div>
    </header>

<main>
    <form action="/technician/new_patient" method="post" enctype="multypart/form-data">
        <div>
            <label>First name</label>
            <input type="text" name="first_name" oninput="capitalizeFirstLetter(this)"> 
        </div>

        <div>
            <label>Last name</label>
            <input type="text" name="last_name" oninput="capitalizeFirstLetter(this)">
        </div>

        <div>
            <label>Date of birth</label>
            <input type="date" name="date_of_birth" min="1900-01-01" max="2023-11-27">
        </div>

        <div>
            <label>Address</label>
            <input type="text" name="address">
        </div>
            
        <div>
            <label>E-mail</label>
            <input type="email" name="email">
        </div>

        <div>
            <label>Jmbg</label>
            <input type="text" name="jmbg" oninput="validateNumber(this)" maxlength="13">
        </div>
            
        <div> 
            <label>Phone number</label>
            <input type="number" name="phone_number">
        </div>

        <div class="btn">
            <button type="submit">Save</button>
        </div>
    </form>
</main>

    <script>

        function validateNumber(input) {
        input.value = input.value.replace(/[^0-9]/g, '');
            if (input.value.length > 13) {
        input.value = input.value.slice(0, 13); 
        }
    }

        document.getElementById('showOptionsBtn').addEventListener('click', function() {
        var optionsContainer = document.getElementById('optionsContainer');

        if (optionsContainer.classList.contains('show')) {
            optionsContainer.classList.remove('show');
        } else {
        optionsContainer.classList.add('show');
        }
    });

    function capitalizeFirstLetter(input) {
            input.value = input.value.charAt(0).toUpperCase() + input.value.slice(1);
        }

    </script>

</body>
</html>