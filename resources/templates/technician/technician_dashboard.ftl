<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Technician dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/technician_dashboard.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" type="text/css" href="https://npmcdn.com/flatpickr/dist/themes/dark.css">
</head>
<body>

  <aside>
    <h1><a href="/technician">MedicalAssistant</a></h1>
    <div id="calendar"></div>
  </aside>

  <main>
     <header>
    <div class="container">
      <button id="showOptionsBtn" ><i class="fa-solid fa-bars"></i></button>
        <div class="options-container" id="optionsContainer">
            <a href="/technician/all_patients">All patients</a>
            <a href="/technician/find_patient">Find patient</a>
            <a href="/technician/new_patient">New patient</a>
            <a href="/technician/new_appointment">New appointment</a>
            <a style="  cursor: pointer;"  onclick="logout()">Logout</a>
            
        </div>
    </div>
  </header>
  
  <div  class="main_div">

    <div class="main_div_container">
    <div id="selectedDateInfo"></div>
      <table>
          <tr>
            <#list appointments as appointment>
              <td>
                <button>${appointment.date}</button>
              </td>
            </#list>
          </tr>
      </table>
      <button id="todayButton">Today date</button>
    </div>
  </div>



  </main>

  <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
  <script>

    function getTodayDate() {
        var today = new Date();
        var year = today.getFullYear();
        var month = (today.getMonth() + 1).toString().padStart(2, '0');
        var day = today.getDate().toString().padStart(2, '0');
        return year + '-' + month + '-' + day;
      }
    //Kalendar
    flatpickr("#calendar", {
        mode: "single",
        inline: true, 
        dateFormat: "Y-m-d", 
        defaultDate: getTodayDate(),
        onChange: function (selectedDates, dateStr) {
        displaySelectedDateInfo(dateStr);
      },
    });

        displaySelectedDateInfo(getTodayDate());

      function displaySelectedDateInfo(date) {
        // Ovde možete ažurirati sadržaj stranice na osnovu izabranog datuma
        // Na primer, možete koristiti AJAX za dohvat podataka sa servera i prikazati ih u #selectedDateInfo elementu
        var selectedDateInfoElement = document.getElementById('selectedDateInfo');
        selectedDateInfoElement.innerHTML = date;
      }

      var todayButton = document.getElementById('todayButton');
      todayButton.addEventListener('click', function () {
        var calendar = document.getElementById('calendar');
        calendar._flatpickr.setDate(getTodayDate(), true);
        displaySelectedDateInfo(getTodayDate());
      });

    document.getElementById('showOptionsBtn').addEventListener('click', function() {
        var optionsContainer = document.getElementById('optionsContainer');

        if (optionsContainer.classList.contains('show')) {
          optionsContainer.classList.remove('show');
        } else {
          optionsContainer.classList.add('show');
        }
      });

    function logout() {
      sessionStorage.clear();
      window.location.href = "/login";
    }

  </script>
</body>
</html>

