import Link from "next/link";
import React from "react";

const Navbar = () => {
    return ( 
        <nav>
            <Link href="/"><a className="logo"><h1>Dogshow management system</h1></a></Link>
            <Link href="/dogs/list"><a className="nav-link">List of entered dogs</a></Link>
            <Link href="/dogs/add"><a className="nav-link">Add new dog to the show</a></Link>
            <Link href="/about"><a className="nav-link">About</a></Link>
        </nav>
     );
}
 
export default Navbar;

