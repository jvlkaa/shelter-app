import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BreedAddComponent } from './breed-add.component';

describe('BreedAddComponent', () => {
  let component: BreedAddComponent;
  let fixture: ComponentFixture<BreedAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BreedAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BreedAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
