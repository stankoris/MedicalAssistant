<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All patients</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/allpatients.css">
</head>
    <body>

        <header>
    <h1><a href="/technician">MedicalAssistant</a></h1>

    <div class="container">
     <button id="showOptionsBtn" ><i class="fa-solid fa-bars"></i></button>
        <div class="options-container" id="optionsContainer">
            <a href="/technician/all_patients">All patients</a>
            <a href="/technician/find_patient">Find patient</a>
            <a href="/technician/new_patient">New patient</a>
        </div>
    </div>
    </header>
        <div class="container">
    <table>
        <thead>
            <tr class="tabela">
                <th>Full name</th>
                <th>Date of birth</th>
                <th>Address</th>
                <th>Email</th>
                <th>Jmbg</th>
                <th>Phone number</th>
            </tr>
        </thead>
        <tbody>
            <#list patients as patient>
                <tr class="patient">
                    <td> <a class="full_name" href="/technician/edit/${patient.patient_id}">${patient.full_name()}</a></td>
                    <td>${patient.date_of_birth}</td>
                    <td>
                        <#if patient.address??>
                            ${patient.address}
                        <#else>
                            N/A
                        </#if>
                    </td>
                    <td>
                        <#if patient.email??>
                            ${patient.email}
                        <#else>
                            N/A
                        </#if>
                    </td>
                    <td>${patient.jmbg}</td>
                    <td>
                    <#if patient.phone_number??>
                            ${patient.phone_number}
                        <#else>
                            N/A
                        </#if>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>

  <script>
    document.getElementById('showOptionsBtn').addEventListener('click', function() {
  var optionsContainer = document.getElementById('optionsContainer');

  if (optionsContainer.classList.contains('show')) {
    optionsContainer.classList.remove('show');
  } else {
    optionsContainer.classList.add('show');
  }
});
  </script>

    </body>
</html>