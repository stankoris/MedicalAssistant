<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Find patients</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/find_patient.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

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

      <form id="searchForm" action="" method="post" enctype="multipart/form-data">
          <input type="text" id="first_name" name="first_name">
          <button type="submit">Search</button>
      </form>

    <table id="patientsTable">
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
        </table>


  <script>

    document.getElementById('showOptionsBtn').addEventListener('click', function() {
    var optionsContainer = document.getElementById('optionsContainer');

    if (optionsContainer.classList.contains('show')) {
        optionsContainer.classList.remove('show');
    } else {
        optionsContainer.classList.add('show');
    }
  });

    document.getElementById('searchForm').addEventListener('submit', function (event) {
        event.preventDefault();

        var searchInput = document.getElementById('first_name').value;

        window.location.href = '/technician/find_patient?first_name=' + searchInput;
    });



    function getPatients() {
    fetch("/technician/new_appointment")
        .then(response => response.json())
        .then(data => {
            // Popunjavanje opcija u select elementu za pacijente
            var selectPatients = document.getElementById("patient_id");
            data.forEach(patient => {
                var option = document.createElement("option");
                option.value = patient.id;
                option.text = patient.name;
                selectPatients.appendChild(option);
            });
        })
        .catch(error => console.error('Error:', error));
}

  </script>
</body>
</html>