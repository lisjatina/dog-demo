
import Link from 'next/link';
import styles from "../../styles/module.css"

const Home = () => {
  return ( 
    <div className={styles.title}>
      <h2>Homepage</h2>
      <Link href="/dogs/list"><a className={styles.btn}>List of all dogs</a></Link>
    </div>
   );
}
 
export default Home;