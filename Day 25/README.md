Student UI — HTML + Tailwind CSS

A simple frontend UI mock built using HTML + Tailwind CSS.
This UI will later connect to a Spring Boot backend.

Features
Student Card UI
Responsive Grid Layout
Tailwind Utility Classes
Styled Buttons (Edit + Delete)
Clean and modern design
Beginner-friendly setup using Tailwind CDN

Tech Stack

HTML5
Tailwind CSS (CDN)

 └── index.html
 

💾 Tailwind Setup (CDN)

Included directly in <head>:

<script src="https://cdn.tailwindcss.com"></script>


No installation required.

🧱 Student Card UI (Example)
<div class="bg-white p-5 rounded-xl shadow-md border hover:shadow-lg transition">
  <h2 class="text-xl font-semibold">Bhanu</h2>
  <p class="text-gray-600 mt-1">Age: 20</p>

  <div class="flex gap-3 mt-4">
    <button class="bg-blue-600 text-white px-4 py-2 rounded-md hover:bg-blue-700">Edit</button>
    <button class="bg-red-600 text-white px-4 py-2 rounded-md hover:bg-red-700">Delete</button>
  </div>
</div>

🖥 Grid Layout (Responsive)
<div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
  <!-- student cards -->
</div>

 What  I Learned

Tailwind basics (colors, spacing, rounded, shadows)

Utility-first styling

Building responsive cards

No custom CSS needed
