<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Technician dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/technician_dashboard.css">
</head>
<body>
<div class="container">
    <#if savePatient?has_content>
        <#if savePatient == "true">
            <div class="success_modal">
                Patient has been saved! 
                <button class="close_button"
                onclick="this.parentElement.remove()">&times;</button>
            </div>
        <#else>
            <div class="error_modal">
                There was an error saving patient!
                <button class="close_button"
                onclick="this.parentElement.remove()">&times;</button>
            </div>
        </#if>
    </#if>

</div>


    <header>
        <a href="/technician/all_patients">All patients</a>
        <a href="/technician/find_patients">Find patient</a>
    </header>

    <main>
    
    </main>
        <form action="/technician/new_patient" method="post" enctype="multypart/form-data">
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
            <div>
                <button type="submit">Save</button>
            </div>
        </form>
    <script>
        function validateNumber(input) {
            input.value = input.value.replace(/[^0-9]/g, '');
            if (input.value.length > 13) {
                input.value = input.value.slice(0, 13); 
            }
        }
    </script>
</body>
</html>