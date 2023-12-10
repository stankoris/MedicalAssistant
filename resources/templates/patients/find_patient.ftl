<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Find patients</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

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









    <form action="">
        <input type="text">
        <button type="submit">Search</button>
    </form>

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